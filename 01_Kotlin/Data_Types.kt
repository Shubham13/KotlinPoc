import java.util.*

fun main(args : Array<String>){

    val value1 = 'A' // char type
    val value2 = "String" // String type
    val flag = true // Boolean

    //Array

    val Id = arrayOf(1,2,3,4,5)
    val firstId = Id[0]
    val lasted = Id[Id.size-1]
    val length_Of_Array = Id.size

    println("Array :")
    println(Arrays.toString(Id))
    println("firstId is ${firstId}")
    println("lastId is $lasted")
    println("Length of Array is $length_Of_Array")
    println()
    //Creating 2-D Array

    val arr_2d = arrayOf(intArrayOf(2,3), arrayOf(4,5))

    println("2d Array : ${Arrays.deepToString(arr_2d)}")
    println()

    //Creating 3-D Array
    println("3d Array : ")
    val arr_3d = arrayOf(arrayOf(intArrayOf(2,3), intArrayOf(4,5)), arrayOf(intArrayOf(6,7), intArrayOf(7,8)))
    println(Arrays.deepToString(arr_3d))

    //Creating Array Using Array Constructor

    //first argument as a size of array
    //second Argument as the function which is used to initialize and return the value of array element given its index.


    val asc = Array(6,{i -> i*3})
    println("Using Constructor")
    println(Arrays.toString(asc))

}
