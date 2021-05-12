//Greater of Two Numbers
fun main(args: Array<String>) {
    var num1: Int = 4
    var num2: Int = 7

    var result: Int = 0
// 1st Method To-do

//    if (num1 > num2)
//        result = num1
//    else
//        result = num2

// 2nd Method To-do As Expression

    result = if (num1 > num2)
        num1
    else
        num2
    println("If-Else :")
    println(result)


// If else If Else

    var a = 4
    var b = 4
    var res: String
    res = if (a > b)
        "a is greater"
    else if (a < b)
        "b is greater"
    else
        "a and b both are equal"
    println()
    println("If else If : ")
    println(res)

// Nested If - else

    val n1 = 25
    val n2 = 20
    val n3 = 30

    val r1 = if (n1 > n2) {

        val max = if (n1 > n3) {
            n1
        } else {
            n3
        }
        max
    } else if (n2 > n3) {
        n2
    } else {
        n3
    }

    print(r1)



}



