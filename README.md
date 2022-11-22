# myPORTsdk

# Table of Contents
- [About](#about)
- [iOS](#ios)
  - [Installation](#installation-ios)
  - [Getting Started](#getting-started-ios)
  - [Usage](#usage-ios)
- [Android](#android)
  - [Installation](#installation-android)
  - [Getting Started](#getting-started-android)
  - [Usage](#usage-android)

# About
myPORT is a mobile framework, that serves as a part of PORT Technology infrastructure and reflects the basic functionality of myPORT's device. It was specially designed with the main aim of simplifying the process of visitor transit management. The framework itself is connected with myPORT's devices and gives for the user / visitor the possibility to get easily access to the public/private destination, as well as get allocation and other possibilities for devices.

# <a id="ios"></a>iOS
## <a id="installation-ios"></a>Installation

## CocoaPods
[CocoaPods](http://cocoapods.org) is a dependency manager for CocoaProjects.
To integrate myPORT into your Xcode project using CocoaPods specify it in your `Podfile`:
```ruby
pod 'myPORTsdk', :git => "git@github.com:myporttechnology/myPORTsdk-deploy.git", :tag => 'iOS.2.2.3'
```
Then, run the following command:
`$ pod install`

## Requirements

- iOS 12.0+
- Xcode 10.0+

## Swift versions
* Swift 5.0


# <a id="getting-started-ios"></a>Getting Started

## Privacy (iOS 13.1) ##
If you are building your app with iOS 13.1 or newer, you need to add privacy key to your app to allow the usage of the Bluetooth, or your app will not launch.

Add the key below to your `Info.plist`, adding strings with the description you want to provide when prompting the user.

```
NSBluetoothAlwaysUsageDescription
```

Add these values to your `Info.plist`, if your application accepts connections from other BLE devices and shares data.

```
<key>UIBackgroundModes</key>
    <array>
        <string>bluetooth-peripheral</string>
    </array>
```

## Privacy (iOS 12.0) ##
If you are building your app with iOS 12.0 or newer, you need to add privacy keys to your app to allow the usage of the Bluetooth, or your app will crash.

Add the keys below to your `Info.plist`, adding strings with the description you want to provide when prompting the user.

```
NSBluetoothPeripheralUsageDescription
NSBluetoothAlwaysUsageDescription
```

Add these values to your `Info.plist`, if your application accepts connections from other BLE devices and shares data.

```
<key>UIBackgroundModes</key>
    <array>
        <string>bluetooth-peripheral</string>
    </array>
```

# <a id="usage-ios"></a>Usage

Add `import myPORTsdk` to the top of your file.

Create an object of ``myPORT``.
```swift
let myPort = myPORTsdk()
```
**Settings**<a id="settings-ios"></a>
Provision myPORT object with settings to enable required functionality:
 ```swift
 public class Settings {
    public init(
        modes: Set<Mode> = [.distant],
        logs: Bool = false,
        cache: Cache? = UserDefaultsCache(),
        journeyRestriction: JourneyRestrictionAlgorithm? = DefaultJourneyRestrictionAlgorithm(),
        distanceLimits: DistanceLimit = DistanceLimit(),
        callbackQueue: DispatchQueue = DispatchQueue.main,
        testModeData: String? = nil,
        policy: String? = nil
    ) {
```
- ``modes``:
    - add distant to enable proximity BLE actions (calling elevator, opening lock)
    - add tap<a id="settings-ios-tap"></a> to enable "card" emulation actions - user should tap BLE reader with his phone
      (passing gate / speed line, opening lock)
    - add test to emulate behavior without having Schindler PORT BLE module (test purpose)
    - add iBeacon to use iBeacon information to find the distance between phone and PORT terminals
- ``logs``: specify true to enable ``subscribeLogs``
- ``cache``: implement your own ``Cache`` to enable custom caching policies. For details see: [Cache](#Cache-ios)
- ``journeyRestriction``: provide a custom algorithm to restrict amount of user interactions. If you don't pass your algorithm the PORT standard implementation will be used. For details see: [Journey Restriction Algorithm](#JourneyRestrictionAlgorithm-ios)
- ``distanceLimits``: minimal RSSI for myPORTsdk to detect PORT devices and definition of proximity. For details see: [DistanceLimit](#DistanceLimit-ios)
- ``callbackQueue``: dispatch queue to perform callbacks. The default value is the main thread of the current process.
- ``testModeData``: json configuration for the test mode. For details see: [Test Mode Data](#TestModeData-ios)
- ``policy``: sdk policy to enable various features

Example:
```swift
let settings = Settings(
    modes: [.distant, .tap],
    logs: true,
    distanceLimits: DistanceLimit(close: -40, detect: -80))
_myPort = myPORTsdk(settings: settings)
```

### <a id="Cache-ios"></a>Cache

Caching various data can significantly improve application UX and performance. It's highly recommended to be implemented and provided.
In order to do this, the following protocol shall be implemented and appropriate object provided as [settings](#settings-ios) parameter.
 ```swift
/// A protocol to support various data caching to improve performance
public protocol Cache: AnyObject {
    /// Stores specified data to cache
    /// - Parameters:
    ///   - value: data to store
    ///   - key: cache entry identifier
    func store(value: Data, for key: String)

    /// Loads specified data from cache
    /// - Parameter key: cache entry identifier
    func load(for key: String) -> Data?
}
```

``UserDefaultsCache`` class is used by default to support caching.
 ```swift
 /// Implements Cache protocol using UserDefaults
public class UserDefaultsCache: Cache {
    /// Implements Cache::store
    public func store(value: Data, for key: String) {

    /// Implements Cache::load
    public func load(for key: String) -> Data? {

    /// Removes all sdk cached values from storage
    /// - Returns: amount of removed keys
    @discardableResult
    public func clear() -> Int {
}
 ```

### <a id="JourneyRestrictionAlgorithm-ios"></a>Journey Restriction Algorithm

The JourneyRescrictionAlgorithm enables custom restrictions to the frequency of actions a user can perform.
 ```swift
/// Defintion of call restriction protocol
public protocol JourneyRestrictionAlgorithm: AnyObject {
    /// Allows to prevent placing to much elevator calls
    /// - Parameter history: the timestamp list of previous calls
    /// - Returns: true when the elevator call should be allowed
    func isCallAllowed(history: [Date]) -> Bool
}
```
To create a custom algorithm you need to implement this protocol. Depending on callHistoryTimeIntervals of the last hour and the currentTime you should decide whether a user is allowed to perform this call or not.

### <a id="DistanceLimit-ios"></a>DistanceLimit

The DistanceLimit provides the possibility to change the rssi values, which define if an AccessObject is detected as close or far.
```swift
/// Defines the RSSI settings to identify proximity zones between terminal and user's phone.
public class DistanceLimit {
    /// RSSI value to detect "close" distance to a device
    let close: Int
    /// RSSI value to detect "proximity" distance to a device
    let proximity: Int
    /// RSSI value to detect "far" distance to a device
    let far: Int
    /// RSSI to consider the beacon
    let detect: Int

    /// ctor
    /// - Parameters:
    ///   - close: RSSI value to detect "close" distance to a device
    ///   - proximity: RSSI value to detect "proximity" distance to a device
    ///   - far: RSSI value to detect "far" distance to a device
    public convenience init(
        close: Int? = nil,
        proximity: Int? = nil,
        far: Int? = nil,
        detect: Int? = nil
    ) {
}
```

### <a id="TestModeData-ios"></a>Test Mode Data

Propagated data in the test mode can be defined via json payload. The specified value shall be object with the following optional values:
- destinations
    - an object with properties from and to
    ```json
    {
        "destinations": {"from": -2, "to": 13}
    }
    ```
    - an object list. Each item of it shall contain property floor and may contain properties: zone, name, location (true should be specified to propagate the destination as current location)
    ```json
        {
            "destinations":[
                {"floor": -1},
                {"floor": 0, "name":"Лоббi", "location": true},
                {"floor": 1},
                {"floor": 7, "name":"Schindler"}
            ]
        }
    ```
- cars: a string list of car names to be used for "test" allocations
    ```json
    {
        "cars":["S13", "U13"]
    }
    ```
- settings: optional setting list. The following setting are supported:
    - allocationDelay, number - milliseconds, the duration of getting elevator allocation
    - stepDuration, number - milliseconds, the pause between steps of journey (changing door state or elevator floor position)
    ```json
    {
        "settings":[
            "allocationDelay": 1500,
            "stepDuration": 1000
        ]
    }
    ```

## Actions

**Start**

Requests to activate myPORTsdk functions. Optional callback can be used to obtain the action result.

```swift
public typealias myPORTCallback = (Result<myPORT>) -> Void
public func start(callback: myPORTCallback? = nil)
```
Example:
```swift
self._myPort.start { result in
    switch result {
    case .failure(let error):
        print("Start Failed: \(error)")
    default:
        break
    }
}
```

**Stop**

Deactivates myPORTsdk functions. Optional callback can be used to obtain the action result.

```swift
public typealias myPORTCallback = (Result<myPORT>) -> Void
public func stop(callback: myPORTCallback? = nil)
```

Example:
```swift
_myPort.stop()
```

## <a id="site-management-ios"></a>User Identity Provisioning

**Common**

Providing ``user identity`` enables the following functionality:
- enabling user settings and preferences for [Journey](#Journey-ios)
- enabling authorization at [AccessObject](#AccessObjects-ios)

User identities can be provisioned in advance (recommended) via [myPORT object](#usage-ios).
Or can be specified as a parameter of [Journey](#Journey-ios) action.

```swift
public typealias VoidCallback = (Result<Void>) -> Void

public func addUserIdentity(
    identity: String,
    callback: VoidCallback? = nil)
```

Example:
```swift
myPort.addUserIdentity(identity: "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9...")
```

## Journey

**Starting Journey**

<a id="Journey-ios"></a>
Initiates user journey (seamless transition) through a building. The journey is a sequence of access object iterations (calling of elevators, opening of doors, etc). The journey path can be specified via following ways:
- Specifying start and destination ``Location(s)`` of demanding journey / transition
- Specifying start ``AccessObject`` and optionally relay on user auto destination (early provisioned information via PORT Gateway).
A ``userIdentity`` access token can be specified as a parameter or provisioned in advance [User Identity Provisioning](#site-management-ios) object.

```swift
public func startJourney(
    start: Location,
    destination: Location,
    userIdentity: String? = nil,
    callback: @escaping (Result<Journey>) -> Void)

public func startJourney(
    accessObject: AccessObject,
    destination: Location,
    userIdentity: String? = nil,
    callback: @escaping (Result<Journey>) -> Void)

public func startJourney(
    _ accessObject: AccessObject,
    userIdentity: String? = nil,
    callback: @escaping (Result<Journey>) -> Void
)
```
Example
```swift
myPort.startJourney(start: current, destination: destination, callback: { (result) in
	switch result {
	case .failure(let error):
	    //TODO: error
	case .success(let journey):
	    //TODO: success
	}
}
```

**Journey progress**

[Journey](#Journey-ios) object exposes a [subscription](#Subscriptions-ios) to progress and notification events. These events can be used to improve UX with your application.

```swift
public enum JourneyState {
    case waiting
    case boarding
    case traveling
    case finished
    case canceled

    /// Returns true when the current journey has been completed (finished or canceled).
    public var completed: Bool
}

public class JourneyInfo {
    /// The journey's state
    public let state: JourneyState
    /// The journey's start location
    public let start: Location
    /// Elevator allocation (when elevator travel is current journey transition segment)
    public var allocation: Allocation?
    /// Involved access object.
    public var accessObject: AccessObject?
}

public typealias JourneyInfoCallback = (JourneyInfo) -> Void

@discardableResult
public func subscribeInfo(
    _ callback: @escaping JourneyInfoCallback,
    observer: AnyObject? = nil) -> ObservationToken
```

Example:
```swift
journey.subscribeInfo({ info in
    switch info.state {
    case .canceled:
        self.showErrorAlert(title: "Canceled", message: "\(journey)")
    case .boarding:
        self.showErrorAlert(title: "Please Board", message: "\(journey)")
    case .finished:
        self.showErrorAlert(title: "Succeeded", message: "\(journey)")
    default:
        if let accessObject = info.accessObject,
            accessObject.lockState == .unlocked {
            self.showErrorAlert(title: "Unlocked", message: "\(accessObject)")
        }
    }
}, observer: self)
```

## Subscriptions
<a id="Subscriptions-ios"></a>

**Common**

Subscription initiating methods returns ``ObservationToken`` object. This object can be used to stops subscription any time.
Optional ``observer`` parameter is suggest to be provided. In this case, the subscription can be terminated automatically, when the observer instance is destroyed.

**Status**

Subscribes to myPORTsdk status changes.
```swift
@discardableResult
public func subscribeStatus(
    _ callback: @escaping StatusCallback,
    observer: AnyObject? = nil) -> ObservationToken
```
Example:
```swift
statusSDKObserver = _myPort.subscribeStatus({ status in
    self.statusLabel.text = status.description
})
```

**BLEStatus**

Subscribes to BLE activity notifications. May be used in debugging purpose or visualized in UI.

```swift
@discardableResult
public func subscribeBLEStatus(
    _ callback: @escaping BLEStatusCallback,
    observer: AnyObject? = nil) -> ObservationToken
```

Example:
```swift
observeBLEStatusObserver = _myPort.subscribeBLEStatus({ status in
    print(status)
})
```

**User at site**
<a id="UserAtSite-ios"></a>

Subscribes to notification about being near or inside PORT site / building.

```swift
@discardableResult
public func subscribeUserAtSite(
    _ callback: @escaping UserAtSiteCallback,
    observer: AnyObject? = nil) -> ObservationToken
```

Example:
```swift
_myPort.subscribeUserAtSite({ userAtSite in
    print("User at site \(userAtSite.atSite): \(userAtSite.siteId)")
}, observer: self)
```

**Destinations**

Subscribes to receive notification about current floor(s) and possible transitions for the current location.
The data describes possible elevator transitions from the current user / mobile device location (considering multiple elevator bank / groups and elevator layouts).

```swift
@discardableResult
public func subscribeDestinations(
    _ callback: @escaping DestinationsCallback,
    observer: AnyObject? = nil) -> ObservationToken?
```
Example:
```swift
_myPort.subscribeDestinations({ destinations in
    print(destinations)
    self._destinations = destinations
}, observer: self)
```

**Access objects**
<a id="AccessObjects-ios"></a>

Subscribes to receive notification about available PORT [Access Objects](#AccessObject-ios) around (door locks, etc).

```swift
@discardableResult
public func subscribeAccessObjects(
    _ callback: @escaping AccessObjectsCallback,
    observer: AnyObject? = nil
) -> ObservationToken
```

Example
```swift
_myPort.subscribeAccessObjects({ objects in
    self._accessObjects = objects
    print("objects: \(objects.map({ $0.siteId }))")
    for object in objects {
        object.subscribeDistanceType({ distance in
            print("\(object) \(distance)")
        }, observer: self)
    }
})
```

**Tap Event**

Subscribes to receive notification about tap actions. This subscription is supported only when [Tap Mode](#settings-ios-tap) has been enabled.

```swift
    @discardableResult
    public func subscribeTapEvent(
        _ callback: @escaping TapEventCallback,
        observer: AnyObject? = nil) -> ObservationToken {
```

Example:
```swift
_myPort.subscribeTapEvent { event in
    print("Tap \(event.accessObject): \(event.result)")
}
```

**Logs**

To improve debuggability and issue investigations, myPORTsdk exposes various log information via Logs subscription.

```swift
@discardableResult
public func subscribeLogs(
    _ callback: @escaping (Any) -> Void,
    observer: AnyObject? = nil) -> ObservationToken
```

Example:
```swift
 _myPort.subscribeLogs({ object in
    print("\(object)")
}
```

## AccessObject
<a id="AccessObject-ios"></a>

``AccessObject`` contains various information about a physical or virtual PORT device or terminal. ``Access objects`` can perform user's authorization requests and can optionally start an automatic journey (seamless transfer) depends on the user's preferences and building layout.

``AccessObject`` exposes the following properties:
- ``siteId``: unique identifier to which belongs the ``AccessObject``
- ``deviceId``: unique identifier of the ``AccessObject`` within the site
- ``types``: supported service type (e.g. elevator, door lock, gate, etc) set
- ``location``: the ``AccessObject`` location

```swift
public class AccessObject: Equatable, Hashable {
    /// the site  identifier
    public private(set) var siteId: SiteId
    /// the  device identifier
    public private(set) var deviceId: DeviceId
    /// the access object's type service type
    public let types: ServiceTypes
    /// the access object's location
    public let location: Location
    /// the door state in case of lock
    public private(set) var doorState: DoorState?
    /// the lock state in case of lock
    public private(set) var lockState: LockState?
    /// optional secure location
    public private(set) var secureLocation: Data?
    /// the "estimated" distance between mobile device and access object
    public internal(set) var distance: Distance = .outOfRange
```

**Distance**

Subscribes to distance changing events of the ``AccessObject``.

```swift
/// Observes distance changing events.
/// - Parameters:
///   - callback: callback to receive notifications
///   - observer: observer object (weak reference to cancel subscription)
/// - Returns: observation token to expose subscription cancel interface
@discardableResult
public func subscribeDistance(
    _ callback: @escaping DistanceCallback,
    observer: AnyObject? = nil) -> ObservationToken
```

**Destinations**

Subscribes to receive the destination list of the ``AccessObject``.
```swift
/// Observes the destinations for this access object
/// - Parameters:
///   - callback: callback to receive notifications
///   - observer: observer object (weak reference to cancel subscription)
/// - Returns: observation token to expose subscription cancel interface
@discardableResult
public func subscribeDestinations(
    _ callback: @escaping DestinationListCallback,
    observer: AnyObject? = nil) -> ObservationToken {
```


# <a id="android"></a>Android
## <a id="installation-android"></a>Installation

**Step 1: Generate a personal access token for GitHub**
-   Inside your GitHub account:
-   Settings -> Developer Settings -> Personal Access Tokens -> Generate new token
-   Make sure you select the following scopes (“ read:packages”) and Generate a token
-   After Generating make sure to copy your new personal access token. You cannot see it again! The only option is to generate a new key.

**Step 2: Store your GitHub — personal access token details**

Create a **github.properties** file within your root Android project
-   In case of a public repository make sure you add this file to .gitignore to keep the token private
-   Add properties **gpr.usr**=_GITHUB_USERID_ and **gpr.key**=_PERSONAL_ACCESS_TOKEN_
-   Replace GITHUB_USERID with personal / organization Github User ID and PERSONAL_ACCESS_TOKEN with the token generated in **Step 1**

**Step 3 : Update build.gradle inside the application module**

Add the following code to **build.gradle** inside the **app** **module** that will be using the myPORTsdk.
```
def githubProperties = new Properties()
githubProperties.load(new FileInputStream(rootProject.file('github.properties')))

repositories {
	maven {
		name = "GitHubPackages"
		url = uri("https://maven.pkg.github.com/myporttechnology/myPORTsdk-deploy")

		credentials {
			username = githubProperties['gpr.usr'] ?: System.getenv("GPR_USER")
			password = githubProperties['gpr.key'] ?: System.getenv("GPR_API_KEY")
		}
	}
}
```

Add the following line inside dependencies of the **build.gradle** of the app module

```
dependencies {
	....
	implementation 'com.schindler.mobile.sdk:myportsdk:2.4.0'
}
```
## Requirements
 - Android SDK 24+
 - Android 7.0+
 - Bluetooth 4.2+

# <a id="getting-started-android"></a>Getting Started
Add following permissions to **AndroidManifest.xml**.
```xml
<uses-permission android:name="android.permission.BLUETOOTH"/>
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN"/>
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />

<uses-feature android:name="android.hardware.bluetooth_le" android:required="true"/>
```

Request permission for location and BLE in MainActivity.
```kotlin
ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),2)
```

## <a id="usage-android"></a>Usage
Add ` import com.schindler.mobile.sdk.api.shared.*` to the top of the file.

Create an object of ``myPORTsdk``.
```kotlin
myPORTsdk(val application: Application)
```

<a id="settings-android"></a>**Settings**

Instantiate the SDK by passing the application to the myPORTsdk.
Afterwards provision the myPORTsdk with settings to enable required functionality:
```kotlin
class Settings(val cache: Cache?,
               val modes: Set<Mode> = setOf(Mode.Distant),
	           val logs: Boolean = false,
               val detailedDestinations: Boolean = false,
               val journeyRestrictionAlgorithm: JourneyRestrictionAlgorithm? = null,
               val distanceLimits : DistanceLimit = DistanceLimit(),
               val callbackContext: CoroutineContext = Dispatchers.Main,
               val testModeData: String? = null,
               val policy: String? = null)
```
- ``cache``: Implement your own ``Cache`` to enable custom caching policies. For details see: [Cache](#cache-android)
- ``modes``: Determines which ``Mode``s will be enabled. For details see: [Modes](#modes-android)
- ``logs``: Specify true to enable `subscribeLogs`
- ``detailedDestinations``: Enable or disabled detailed destinations from Destinations subscription. For details see: [Destinations](#destinations-android)
- ``language``: Defines the language as an iso String in which the destinations will be returned. If no language is provided the language of the PORT device will be used. If there is no translation an empty string will be returned.
- ``journeyRestrictionAlgorithm``: Provide a custom algorithm to restrict the amount of user interactions. If you don't pass your algorithm the PORT standard implementation will be used.
For details see: [Journey Restriction Algorithm](#journey-restriction)
- ``distanceLimits``: RSSI values to detect an AccessObject as close or far. For details see: [DistanceLimit](#distancelimit-android)
   :warning: Changing of the distanceLimits can lead to bad user experience.
- ``callbackContext``: Context to perform callbacks. The default value is the main thread of the current process.
- ``testModeData``: json configuration for the test mode. For details see: [Test Mode Data](#TestModeData-android)
- ``policy``: sdk policy to enable various features

Example
```kotlin
val settings = Settings(logs = true, modes = setOf(Mode.Distand, Mode.Tap)
val myPORT = myPORTsdk(application, settings)
```

**<a id="modes-android"></a>Modes**

The SDK supports different modes. The following modes are supported.


| Mode                | Functionality                                                                             | Requirements |
| :-------------------|:------------------------------------------------------------------------------------------|:-------------|
| ``Mode.Distant``    | Add Distant to enable proximity BLE actions (calling elevator, opening lock). The following functions are supported: ``startJourney``, callbacks from [Subscriptions](#Subscriptions-android).                  |BLE           |
| ``Mode.Tap``        | Add Tap to enable "card" emulation actions - user should tap the reader with his phone (passing gate/speed line, opening lock). For this mode an user identity is mandatory. |NFC           |
| ``Mode.Test``       | add Test to emulate behavior without having Schindler PORT BLE module (test purpose)  |-             |

:warning: If both ``Mode.Distant`` and ``Mode.Tap`` are enabled ``startJourney`` and the callbacks from [Subscriptions](#Subscriptions-android) can cause doubly messages.


### <a id="cache-android"></a>Cache

Caching various data can significantly improve application UX and performance. It's highly recommended to be implemented and provided.
In order to do this, the following protocol shall be implemented and appropriate object provided as [settings](#settings-android) parameter.
 ```kotlin
interface Cache {
    fun store(key: String, value: String)
    fun load(key: String): String?
    fun delete(key: String)
}
```

``SharedPreferencesCache`` class can be used as default to support caching.
```kotlin
// Implements Cache interface using SharedPreferences
class SharedPreferencesCache(context: Context): Cache {
    // Implements Cache::store
    override fun store(key: String, value: String) {

    // Implements Cache::load
    override fun load(key: String): String? {

    // Implements Cache::delete
    override fun delete(key: String){

    // Removes all sdk cached values from storage
    // - Returns: amount of removed keys
    fun clear(): Int {
}
 ```

### <a id="journey-restriction"></a>Journey Restriction Algorithm
The ``JourneyRescrictionAlgorithm`` enables custom restrictions to the frequency of actions a user can perform.
```kotlin
interface JourneyRestrictionAlgorithm {
    fun isCallAllowed(currentTime: Long, callHistory: List<Long>): Boolean
}
```
To create a custom algorithm you need to implement this interface. Depending on the ``callHistory`` of the last hour and the ``currentTime`` you should decide whether a user is allowed to perform this call or not.

### <a id="distancelimit-android"></a>DistanceLimit

The ``DistanceLimit`` provides the possibility to change the rssi values, which define if an AccessObject is detected as close or far.
 ```kotlin
    class DistanceLimit(
       farDetectionRssi: Int = BleHelper.RSSI_FAR_DEFAULT,
       closeDetectionRssi: Int = BleHelper.RSSI_CLOSE_DEFAULT
	)
```

### <a id="TestModeData-android"></a>Test Mode Data

Propagated data in the test mode can be defined via json payload. The specified value shall be object with the following optional values:
- destinations
    - an object with properties from and to
    ```json
    {
        "destinations": {"from": -2, "to": 13}
    }
    ```
    - an object list. Each item of it shall contain property floor and may contain properties: zone, name, location (true should be specified to propagate the destination as current location)
    ```json
        {
            "destinations":[
                {"floor": -1},
                {"floor": 0, "name":"Лоббi", "location": true},
                {"floor": 1},
                {"floor": 7, "name":"Schindler"}
            ]
        }
    ```
- cars: a string list of car names to be used for "test" allocations
    ```json
    {
        "cars":["S13", "U13"]
    }
    ```
- settings: optional setting list. The following setting are supported:
    - allocationDelay, number - milliseconds, the duration of getting elevator allocation
    - stepDuration, number - milliseconds, the pause between steps of journey (changing door state or elevator floor position)
    ```json
    {
        "settings":[
            "allocationDelay": 1500,
            "stepDuration": 1000
        ]
    }
    ```

## Actions
:warning: The SDK has to get initialized before using these actions.

**Start**

Start searching for myPORT devices. Optional callback can be used to obtain the action ``Result``.
```kotlin
typealias Callback = (Result<Unit>) -> Unit
fun start(callback: Callback? = null)
```
Example
```kotlin
myPORT.start()
```

**Stop**

Stop searching for myPORT devices. Optional callback can be used to obtain the action ``Result``.
```kotlin
fun stop(callback: Callback? = null)
```
Example
```kotlin
myPORT.stop()
```

## Journey

**Starting Journey**
:warning: The [Mode](#modes-android) has to support ``startJourney`` otherwise an error is returned by the callback.
<a id="Journey-android"></a>
Initiates user journey (seamless transition) through a building. The journey is a sequence of access object iterations (calling of elevators, opening of doors, etc). The journey path can be specified via following ways:
- Specifying start and destination ``Location(s)`` of demanding journey / transition
- Specifying start ``AccessObject`` and optionally relay on user auto destination (early provisioned information via PORT Gateway).
A ``JWT`` access token (userIdentity) can be specified as a parameter or provisioned via ``addUserIdentity`` method.

:warning: Starting a Journey from an AccessObject is only available if you set the JWT userIdentity in the ``addUserIdentity`` method or provide it when calling ``startJourney``.


```kotlin
typealias JourneyCallback = (Result<Journey>) -> Unit

fun startJourney(
        start: Location,
        destination: Location,
        userIdentity: String? = null,
        callback: JourneyCallback)

fun startJourney(
        accessObject: AccessObject,
        userIdentity: String? = null,
        callback: JourneyCallback)
```
Example
```kotlin
myPORT.startJourney(start, destination){result ->
	if(result.isSuccess()){
		// subscribe to journey
        var journey = result.value()
		journey?.subscribeInformation(::journeyInformationChanged)
	}else{
        var errorMessage = result.error()
        // handle error
    }
}

myPORT.startJourney(door){ result ->
	if(result.isSuccess()){
		// subscribe to journey
        journey = result.value()
		journey?.subscribeInformation(::accessObjectJourneyInformationChanged)
	}else{
        var errorMessage = result.error()
        // handle error
    }
}

...
private fun journeyInformationChanged(journeyInformation: JourneyInformation) {
    val elevatorName = journeyInformation.allocation?.name
    // display elevator name on UI
}

...
private fun accessObjectJourneyInformationChanged(journeyInformation: JourneyInformation) {
    if(journeyInformation.state == JourneyState.Traveling){
        // show traveling UI
    }
    else if(journeyInformation.state == JourneyState.Finished){
        // show journey finished UI
    }
    ...
}
```

**Journey progress**

[Journey](#Journey-android) object exposes a [subscription](#subscriptions-android) to progress and notification events. These events can be used to improve UX with your application.
```kotlin
private fun journeyInformationChanged(journeyInformation: JourneyInformation) {
	//Display journey to user
}

data class JourneyInformation (var state: JourneyState,
			       var start: Location,
			       var allocation: Allocation?,
			       var accessObject: AccessObject?)
```


## <a id="subscriptions-android"></a> Subscriptions
:warning: Subscriptions are only working if either ``Mode.Distant`` or ``Mode.Test`` is enabled.


For every subscription you can either pass a callable reference, lambda expression or an anonymous function as a callback.
Optional a callback context can be provided. This defines on which thread the callback is called, where the main thread is used as default.

<a id="destinations-android"></a>**Destinations**

Subscribes to receive notification about current floor(s) and possible transitions for the current location. The data describes possible elevator transitions from the current user / mobile device location (considering multiple elevator groups and elevator layouts).


The transitions property of ``Destinations`` contains as keys the possible start ``Location``s and as values the corresponding available destination ``Location``s.
Depending on ``Settings.detailedDestinations`` it will return detailed ``Destinations`` for each Location or aggregated ``Destinations`` by floor.

```kotlin
typealias DestinationsCallback = (Destinations) -> Unit

data class Destinations (val transitions: Map<Location, Set<Location>>)

fun subscribeDestinations(callback: DestinationsCallback): Subscription
```
Example
```kotlin
myPORT.subscribeDestinations(::destinationsChanged)
...
private fun destinationsChanged(destinations: Destinations) {
	//show destinations to user
}
```
**Status**

Subscribe to the change of SDK ``Status``.

One of the two classes is ``Status``, which returns the state of the SDK itself.

The ``Status`` has the following values.
```kotlin
typealias StatusCallback = (Status) -> Unit

sealed class Status : Parcelable {
    class Error(val error: SdkError) : Status()
    object Started: Status()
    object Stopped: Status()
}
```
```kotlin
fun subscribeStatus(callback: StatusCalback): Subscription
```
Example
```kotlin
myPORT.subscribeStatus(::statusChanged)
...
private fun statusChanged(status: Status) {
    if(status is Status.Error){
        //turn on bluetooth, restart bluetooth, ...
    }
}
```

Subscribe to the change of ``BLEStatus``.

The second class  is ``BLEStatus``, which returns the state of the BLE communication.
The ``BLEStatus`` has the following values.
```kotlin
typealias BLEStatusCallback = (BLEStatus) -> Unit

sealed class BLEStatus : Parcelable {
    class Error(val error: BleError) : BLEStatus()
    object Connecting : BLEStatus()
    object Connected : BLEStatus()
    object Disconnecting : BLEStatus()
    object Scanning : BLEStatus()
}
```
```kotlin
fun subscribeBLEStatus(callback: BLEStatusCalback): Subscription
```
Example
```kotlin
myPORT.subscribeBLEStatus(::bleStatusChanged)
...
private fun bleStatusChanged(bleStatus: BLEStatus) {
    if(bleStatus is BLEStatus.Error){
        // handle error
    }
}
```
**Access objects**

Subscribes to receive notification about available PORT access objects around (door locks, etc). `AccessObject` contains various information about a physical or virtual PORT device or terminal. Access objects can perform user's authorization requests and can optionally start an automatic journey (seamless transfer) depends on the user's preferences and building layout.

``AccessObjects`` contains a set of currently available ``AccessObject``s.
```kotlin
typealias AccessObjectsCallback = (AccessObjects) -> Unit

data class AccessObjects internal constructor(val accessObjects: Set<AccessObject>) : Parcelable

data class AccessObject internal constructor(
    val siteId: UShort,
    val accessObjectId: ULong,
    val type: DeviceType,
    val location: Location,
    val distance: Distance,
    var lockState: LockState? = null,
    var doorState: DoorState? = null
) : Parcelable
```

```kotlin
fun subscribeAccessObjects(callback: AccessObjectsCallback): Subscription
```
Example
```kotlin
myPORT.subscribeAccessObjects(::accessObjectsChanged)
...
private fun accessObjectsChanged(accessobjects: AccessObjects){
	//present the user more potential opportunities to start a journey
}
```
**User at site**

Subscribes to notification about being near or inside PORT site / building.

The ``UserAtSite`` Object represents the information received when the user leaves or enters a site.
```kotlin
typealias UserAtSiteCallback = (UserAtSite) -> Unit

data class UserAtSite internal constructor(val atSite: Boolean,
                                           val siteId: UShort) : Parcelable

fun subscribeUserAtSite(callback: UserAtSiteCallback): Subscription
```
Example
```kotlin
myPORT.subscribeUserAtSite(::userAtSiteChanged)
...
private fun userAtSiteChanged(userAtSite: UserAtSite) {
	//Manage identity and site
	...
}
```

**Logs**

To improve debuggability and issue investigations, myPORTsdk exposes various log information via Logs subscription.

```kotlin
typealias LogCallback = (SdkLog) -> Unit

data class SdkLog internal constructor(val tag: String,
                                       val message: String) : Parcelable

fun subscribeLogs(callback: LogCallback): Subscription

```

Example:
```kotlin
myPORT.subscribeLogs(::logsChanged)
...
private fun logsChanged(sdkLog: SdkLog) {
	// use sdkLog.message for debugging reasons
}
```

**Unsubscribe**

To unsubscribe the dunction pointer received on subscription can be called.

Example
```kotlin
//Subscribe
val destinationsSubscription = myPORT.subscribeDestinations(::destinationsChanged)
...
//Unsubscribe
destinationSubscription()
```

## <a id="site-management"></a>user Identity Provisioning

The ``addUserIdentity`` method is used to set user identities as a JWT String enabling additional features:
 - Receiving user specific Locations in ``subscribeDestinations``.
 - Enabling user specific journey possibilities in ``startJourney``.
 - Gaining access to protected sites.

There are two possibilities to configure a ``SiteAgency``.

- Configuring the SiteAgencies before starting the SDK by providing them to the ``Settings`` in the ``initialize`` function.
- Setting the parameters of a SiteAgency after receiving the UserAtSite event.

**Configuring with settings**

This allows you to pass the settings of the ``siteKey``s for protected sites and jwt userIdentities to the myPORTsdk before starting.


Example
```kotlin
myPORT.addUserIdentity("jwt_identity")
```

The ``addSiteKey`` method allows you to pass a ``siteKey`` for protected sites.
Example
```kotlin
myPORT.addUserIdentity("{siteId: 12345, siteKey: 'AE12F3'}")
```
