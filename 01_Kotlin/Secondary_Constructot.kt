fun main(args:Array<String>){

    var student = Studen("Sriyank",10)
    print(student.id)
}

class Studen(var name:String){ // Primary Constructor
    var id: Int = -1
    init{
        println("Student has got a name as $name and id is $id")
    }
    constructor(n: String,id:Int):this(n){ // we cannot declare the property val or var inside the secondary constructor
        // If We're declaring the secondary constructor , then we must give the call to the primary constructor( : this(n) )
        // The body of the secondary constructor is called after init block
        this.id = id
    }

}