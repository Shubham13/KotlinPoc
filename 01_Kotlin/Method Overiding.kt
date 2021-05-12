/*
parent class and its method or property which is to be overidden must be open (non -final)
Method name of base class and derived class must have same
Method must have same parameter as in base class


 */

open class Bird{
    open fun fly(){
        println("Bird is flying ")
    }
}

class Parrot:Bird(){
    override fun fly() {
        println("Parrot is flying ")
    }
}

class Duck:Bird(){
    override fun fly(){
        println("Duck is flying ")
    }
}

fun main(args:Array<String>){
    val p = Parrot()
    p.fly()
    val d = Duck()
    d.fly()
}