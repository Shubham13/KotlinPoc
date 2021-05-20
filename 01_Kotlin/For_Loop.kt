fun main(args : Array<String>){
    val marks = arrayOf(1,2,3,4,5,6,7,8,9)
    for (item in marks)
    println(item)
    println(marks.indices)

    for (items in marks.indices)
        println("marks[$items] :"+ marks[items])

    print("for(i in 1..5)print(i)=")
    for(i in 1..5)print(i)
    println()
    print("for(i in 5..1)print(i)=")
    for(i in 5..1)print(i)
    println()
    print("for(i in 5 downTo 1)print(i)=")
    for(i in 5 downTo 1)print(i)
    println()
    print("for(i in 1..5 step 2)print(i)=")
    for(i in 1..5 step 2)print(i)
    println()
    print("for(i in 5..1 step 2)print(i)=")
    for(i in 5 downTo 1 step 2)print(i)





}
