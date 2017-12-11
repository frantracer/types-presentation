class RandomSet[A](val seed: Int, val elements: List[A]) {
  private val rand = new scala.util.Random(seed)
  def push(element: A) : RandomSet[A] =
    new RandomSet(seed, element :: elements)
  def getRandom(): A =
    elements(rand.nextInt(elements.length))
}

object Generics extends App {
  val my_rset : RandomSet[Int] =
    new RandomSet[Int](1, List[Int](10, 54)).push(32)
  println(my_rset.getRandom())
}
