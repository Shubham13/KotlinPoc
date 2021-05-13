// By default Whatever we define in Interface is abstract in nature
// In case of Interface Nothing is Final , Everything is open


fun main(args:Array<String>){


//    var myObj = MyInterfaceListener() Cannot be Instantiated coz It's not having any primary constructor
    var myBtn = MyButton()
    myBtn.onTouch()
    myBtn.onClick()

}

interface MyInterfaceListener{ // Interface cannot be Instantiated or You cannot create instance of abstract class

     var name:String  // Properties in interface are abstract by default
      fun onTouch()   // Methods in Interface are abstract by default

// Error On : public Final fun onClick(){   reason : In case of Interface Nothing is Final , Everything is open

     fun onClick(){     // Normal Methods are public and open by default NOT FINAL
    println("onClick Interface Code : Button clicked")
     }
}

class MyButton : MyInterfaceListener{ //Interface for the Button and No Primary Constructor

    override var name:String = "dummy_name"

    override fun onTouch(){
        println("Button was touched")
    }
    override fun onClick(){ // Optional to Override
        super.onClick()
        println("Button was clicked")
    }
}