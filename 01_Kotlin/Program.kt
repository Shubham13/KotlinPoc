import Program.MyInterface as MyInterface

class Program{
    fun main(args:Array<String>){
        val program = Program()
        program.addTwoNumbers(2,7)
        program.addTwoNumbers(2,8, object : MyInterface{
            override fun execute(sum: Int) {
                println(sum)
            }
        })


    }

    fun addTwoNumbers(a:Int,b:Int,action: MyInterface){
        val sum = a + b
        action.execute(sum)


    }

    fun addTwoNumbers(a:Int,b:Int){
        val sum = a + b
        println(sum)

    }

    interface MyInterface{
        fun execute(sum: Int)
    }

}
