class Account {
    var acc_no:Int = 0
    var name: String = ""
    var amount: Float = 0.toFloat()

    fun insert(ac:Int,n:String,am:Float){
        acc_no = ac
        name = n
        amount = am
        println("Account no: ${acc_no} holder :${name} amount :${amount}")

    }


}

//Nested Class
//Class which is created inside another class, By default it's static , so it's data member and member function can be accessed without creatign an object of class

class outerClass{
    private var name  ="Himanshu"
    class nestedClass{
        var description: String  = "code Inside nested class"
        private var id: Int = 101
        fun foo(){
            print("Id is $id")
//         print("name is ${name}")// cannot access the outer class member
        }
    }
}




fun main(args: Array<String>){
    Account()
    var acc = Account()
    acc.insert(7000127 ,"Himanshu",1000f)
    println("${acc.name}")

// Nested Class
    var obj = outerClass.nestedClass()
    obj.foo()


}