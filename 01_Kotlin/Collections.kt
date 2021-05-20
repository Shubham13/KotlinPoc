fun main (args:Array<String>){
    var intList: List<Int> = listOf<Int>(1,2,3)
    var stringList: List<String> = listOf<String>("Ajay","Vijay","Prakash")
    var anyList: List<Any> = listOf<Any>(1,2,3,"Ajay","Vijay","Prakash")

    println(stringList.get(0))
    println(stringList.indexOf("Vijay"))
    println(stringList.lastIndexOf("Vijay"))
    println(stringList.size)

    var mutableListInt: MutableList<Int> = mutableListOf<Int>()
    var mutableListString: MutableList<String> = mutableListOf<String>()
    var mutableListAny: MutableList<Any> = mutableListOf<Any>()

    val mutableMap: MutableMap<String, String> = mutableMapOf<String, String>()
    mutableMap.put("name", "Ashu")
    mutableMap.put("city", "Delhi")

}