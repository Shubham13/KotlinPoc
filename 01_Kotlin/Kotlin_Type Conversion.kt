fun main(args: Array<String>)
{
    var value1 = 10

// val value2 : Long = value1 // Error Implicit Conversion is not possible in Kotlin

// Explicitly Convert
    val value2: Long = value1.toLong()

    println(value2)
    println("value2 is Long : ${value2 is Long}")
}
/*
toByte()
toShort()
toInt()
toLong()
toFloat()
toDouble()
toChar()
 */