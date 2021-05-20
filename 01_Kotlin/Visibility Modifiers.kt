/*
Public
protected :- Not applicable for Top- Level  function and Class {Variables are visible only in the sub class}
internal :- Within the same module
private :- Within the same class
 */

// person.a , person.b are not visible
//person.c ,person.d are visible


class TestClas{
    fun testing(){
        var person = Person()
        print(person.c)
    }
}


 open class Person{ // Super Class
    private val a = 1
     protected val b =2
     internal val c = 3
     val d = 10 // public by default
}

class Indian:Person(){ //Derived class or Sub - Class
    // a is not visible
    // b, c, d is visible
    fun test(){
        print(d)
    }
}