//If we define any abstract keyword in the superclass of Person1 , so we need to override method inside the sub - class Indian
// By default abstract are open
// open can and cannot be override to the sub class but abstract class must be override in sub-class
// Use Alt + Enter to Override

fun main(args:Array<String>){

    // var person = Person1() // Cannot Create an Instance of Abstract classes
}

abstract class Person1 {
//    open var name:String = "dummy_name"
    abstract var name:String //abstract variable cannot be initialized like abstract methods don't have body

    abstract fun eat() // abstract properties are "open" by default and they don't have body
    open fun getHeight() {} //A "open function ready to be Overridden"
    fun goToSchool() {} // A Normal Function : public and final by default
}	

class Indian1() : Person1(){
    override var name: String = "dummy_indian_name"


//    override var name:String = "dummy_indian_name"

    //    override fun eat(){
//
//    }
//
//    override fun getHeight() {
//
//    }
    override fun eat() {
        TODO("Not yet implemented")
    }
}