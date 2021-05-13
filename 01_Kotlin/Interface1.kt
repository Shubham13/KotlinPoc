// By default Whatever we define in Interface is abstract in nature
// In case of Interface Nothing is Final , Everything is open


fun main(args:Array<String>){


//    var myObj = MyInterfaceListener() Cannot be Instantiated coz It's not having any primary constructor
    var myBtn = MyButton1()
    myBtn.onTouch()
    myBtn.onClick()

}

interface MyInterfaceListener1{ // Interface cannot be Instantiated or You cannot create instance of abstract class


    fun onTouch()   // Methods in Interface are abstract by default

// Error On : public Final fun onClick(){   reason : In case of Interface Nothing is Final , Everything is open

    fun onClick(){     // Normal Methods are public and open by default NOT FINAL
        println("onClick Interface Code : Button clicked")
    }
}

interface MySecondInterface1{ // Interface cannot be Instantiated or You cannot create instance of abstract class


    fun onTouch() { //Normal Method
        println("MySecondInterface: onTouch")
    }



    fun onClick(){     // Normal Methods are public and open by default NOT FINAL
        println("onClick Interface Code : Button clicked")
    }
}

class MyButton1 : MyInterfaceListener1 , MySecondInterface1{ //Interface for the Button and No Primary Constructor
    override fun onTouch() {
       super.onTouch() // Normal method of MySecondInterface will be called , coz Interface1 onTouch is abstract and it doesnot have any body
    }

    override fun onClick() {
      super<MyInterfaceListener1>.onClick()
        super<MySecondInterface1>.onClick()
    }


}


// Rule : If their are two Interface and their are two normal methods of the same name inside both the interface and you need to override that method as well

//Interface can contains both Normal Methods and abstract methods
//But they contains only Abstract Property (We cannot Initialize Variables)
//Interface are NOT class
// You Cannot create instance if an Interface similar to an Abstract class
