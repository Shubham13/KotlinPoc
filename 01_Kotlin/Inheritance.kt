// classes are final by default , they cannot be inherited simply, Open Keyword before the class to inherit a class and make it non - final

open class Base{
    val x = 10
}
class Derived: Base(){
    fun foo(){
        println("x is equal to "+x)
    }

}

fun main (args:Array<String>){
    val derived = Derived()
    derived.foo()

    val obj1 = Programmer("Himanshu",20,1000f)
    obj1.doProgram()
    val obj2 = Salesman("Himanshu",20,1000f)
    obj2.fieldWork()

}



open class Employee(name:String,age:Int,salary:Float){
    init {
        println("Base Class")
        println("Name is $name")
        println("Age is $age")
        println("salary is $salary")

    }
}

class Programmer(name: String , age:Int,salary: Float):Employee(name,age,salary){
    fun doProgram(){
        println("Programming")

    }
}


class Salesman(name: String , age:Int,salary: Float):Employee(name,age,salary){
    fun fieldWork(){
        println("travelling")

    }
}