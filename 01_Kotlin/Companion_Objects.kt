fun main(args:Array<String>){

    MyClass.count
    MyClass.typeOfCustomers()

}

class MyClass{
   companion object  {
        var count:Int = -1 // Behaves like STATIC variable


        fun typeOfCustomers(): String{ // Behaves like STATIC variables
            return "Indian"
        }


    }


}

