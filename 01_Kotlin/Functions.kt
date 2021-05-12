fun main(args:Array<String>){
    var n1 = 4
    var n2 = 5
    var res = product(n1,n2)
    println("product is $res")
    sum()
    print("code after sum")
}
fun sum(){
    var num1 = 5
    var num2 = 6
    println("Sum = "+(num1 + num2))
}

fun product(a:Int,b:Int):Int{

    val product = a * b
    return product
}