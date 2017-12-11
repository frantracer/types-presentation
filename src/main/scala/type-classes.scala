object TypeClasses extends App {

    trait LogConverter[A] {
        def toLogString(a: A): String
    }

    def toLogString[A](a: A)(implicit lc: LogConverter[A]) = lc.toLogString(a)

    implicit val intToLogString = new LogConverter[Int] {
        def toLogString(int: Int): String = s"int $int"
    }
    implicit val strToLogString = new LogConverter[String]
    {
        def toLogString(str: String): String = s"str $str"
    }

    println(toLogString(20))
    println(toLogString("hola"))

}
