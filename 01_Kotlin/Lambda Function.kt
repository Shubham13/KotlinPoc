// Lambda is a function which has no name. Lambda is defined with a curly braces {} --> variable as a parameter and body of function

/*
Syntax of Lambda Function
{variable -> body_of_function}

 */

fun main(args:Array<String>){
    val myLambda: (Int) -> Unit = {s:Int -> println(s)}
    addNumber(5,10,myLambda)

    val test: String = "Hello"
   val myLamb : (Int) -> Unit=  { s : Int ->   println(s)  }

    //  val myLamb : (Int) -> Int=  { s : Int ->   2 + 3  }
    // val myLamb : (Int) -> Unit=  { s : Int ->   "Hello"  }
    addTwoNumbers(2,8,myLamb)
}

fun addNumber(a:Int,b:Int,mylambda: (Int) -> Unit){
    val add = a + b
    mylambda(add)
}

fun addTwoNumbers(a:Int,b:Int,action: (Int) -> Unit){

    var sum = a +b
    action(sum) // println(sum)
    //println(sum)
}