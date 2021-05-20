//Creating Object of Class (Alien) and Using Variables of it.
fun main(args: Array<String>) {
    println("Hello World!")

    var jacky = Alien();

    jacky.name = "Himanshu"
    println("Name is : ${jacky.name}")


    jacky = Alien();
    println("Name is : ${jacky.name}")
}