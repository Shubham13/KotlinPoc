import java.lang.ArithmeticException

/*
ArithemeticException
Arr Indx Out of Bound
SecurityException
NullPointerException

Exception Handling:
try
catch
finally
throw


 */

fun main(args:Array<String>){
    try {
        val data = 20 /0
    }
    catch (e : ArithmeticException){
        println(e)
    }

    var str = getNumber("10")
    println(str)

}

fun getNumber(str : String):Int{
    return try {
        Integer.parseInt(str)
    }catch (e: ArithmeticException){
        0
    }
}