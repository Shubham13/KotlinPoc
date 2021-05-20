fun main(args:Array<String>){

    CustomerData.count = 98
    CustomerData.typeOfCustomers()

    println(CustomerData.count)

    CustomerData.count = 109
    println(CustomerData.count)

    CustomerData.myMethod("Hello")
}

open class MySuperClass{
   open fun myMethod(str:String){
        println("MySuperClass")
    }
}

object CustomerData : MySuperClass(){
    var count:Int = -1 // Behaves like STATIC variable
    fun typeOfCustomers(): String{ // Behaves like STATIC variables
        return "Indian"
    }

    override fun myMethod(str: String) { // Currently Behaving Like a static method
        super.myMethod(str)
        println("objectCustomerData "+ str)
    }
    init {

    }
}