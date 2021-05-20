fun main(args:Array<String>){

    var student = Student("Himanshu")
    student.name = "John"
    println("Called from Main \nStudent got a name ${student.name}")


}

class Student(var name:String){
//    var name = "dummy"
    init{
//        this.name = _name
        println("Student has got a name as ${name}")
    }
}