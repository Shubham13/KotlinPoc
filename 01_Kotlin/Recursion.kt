var count = 0
fun rec(){
    count++
    if(count<=5){
        println("Count : $count")
        rec()
    }
}

fun factorial(n:Int): Long{
    if (n == 1)
       return n.toLong()
    else
       return n*factorial(n-1)
}


tailrec fun recursiveSum(n: Long,semiresult:Long = 0): Long{
    return if(n<=0){
        semiresult
    }
    else{
        recursiveSum((n-1),n+semiresult)
    }



}






fun main(args:Array<String>){
    rec()
    var num = 5
    var result:Long = factorial(num)
    println("Factorial of a number : $result")
    println("recursive sum is ${recursiveSum(num.toLong())}")
}