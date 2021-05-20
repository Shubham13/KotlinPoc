fun myFun(org: String , portal: String, fn:(String,String) -> String): Unit{ // Passing as Parameter
    val result = fn(org,portal)
    println(result)
}
fun main(args:Array<String>){
    val fn:(String,String) -> String = { org,portal -> "$org develop $portal" } // lambda function
    myFun("kotlinlang.org","Kotlin.com",fn)
}