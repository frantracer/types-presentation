import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.numeric._
import eu.timepit.refined.string._

object RefinedTypes extends App {

    /* Positive numbers */
    val positive_1: Int Refined Positive = 5
    //val positive_2: Int Refined Positive = -5 // Compile error

    /* Numbers greater than 5 */
    val greater_than_five_1: Int Refined Greater[W.`5`.T] = 10
    //val greater_than_five_2: Int Refined Greater[W.`5`.T] = 1 // Compile error

    /* Regex: is a natural number */
    println("Introduce a natural number:")
    type NaturalNumberRegex = MatchesRegex[W.`"[0-9]+"`.T]
    val natural_number_1: String Refined NaturalNumberRegex = "920"
    //val natural_number_2: String Refined NaturalNumberRegex = "Scala" // Compile error

    // Errors in execution time
    println("Introduce a positive number:")
    val positive_input = refineV[Positive](scala.io.StdIn.readInt())
    positive_input.map(_ + 5) match {
        case Left(x) => println(s"ERROR: $x")
        case Right(x) => println(s"OK: x + 5 = $x")
    }

    // Regex checks
    println("Introduce a natural number:")
    val natural_number_str = refineV[NaturalNumberRegex](scala.io.StdIn.readLine())
    natural_number_str.map(_ + 5) match {
        case Left(x) => println(s"ERROR: $x")
        case Right(x) => println(s"OK: $x")
    }

}