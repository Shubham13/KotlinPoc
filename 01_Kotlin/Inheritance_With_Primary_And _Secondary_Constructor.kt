import java.awt.Color

fun main(args:Array<String>){

    var dog = Dog("Black","Pug")


}

open class Animal{ //Super Class
    var color: String = ""
    constructor( color: String ){
        this.color = color
        println("From Dog: $color ")
    }

}

class Dog: Animal{
    var breed : String = ""
    constructor(color : String ,  breed: String):super(color){
        this.breed = breed

        println("From Dog: $color and $breed")
    }
}