fun main(args:Array<String>){
    var number = 4
    var numberProvided = when(number){
        1 -> "one"
        2 -> "two"
        3 -> "three"
        4 -> "Four"
        5 -> "Five"

        else -> "Invalid Number"
    }
    println(" You Provided $numberProvided")


    // Multiple Branches When
    var n = 8
    when(n){
        3,4,5,6 ->
            println("It is summer season")
        7,8,9 ->
            println("It is Rainy Season")
        10,11 ->
            println("It is Autumn season")
        12,1,2 ->
            println("It is Winter Season")
    }

//    When in the range
// A range is created using ..(double dot)

var number1 = 5
when(number1){
    in 1..5 -> println("Input is in the the range 1 to 5")
    in 6..10 -> println("Input is in the range 6 to 10")
    else -> println("none of the above")
}


}