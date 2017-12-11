object TypeErasure extends App {
    val string_list : List[String] = List[String]("hello")
    println(string_list.getClass)
    // class scala.collection.immutable.$colon$colon

    val int_list : List[Int] = List[Int](1)
    println(int_list.getClass)
    // class scala.collection.immutable.$colon$colon

    // Functions signatures problems
    def print_list(list : List[Int]) = {
        list.map(int => println(int))
    }

    // Compile error: Same signature after type erasure
    /*
    def print_list(list : List[String]) = {
        list.map(string => println(string))
    }
    */
}