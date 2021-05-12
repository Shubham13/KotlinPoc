fun main(args:Array<String>){
    labelname@ for(i in 1..3){
        for(j in 1..3){
            println("i =$i and j = $j")
            if (i == 2){
                continue@labelname
            }
            println("this is below if")
        }
    }
}