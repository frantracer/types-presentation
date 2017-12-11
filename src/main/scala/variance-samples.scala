object VarianceSamples extends App {

    class Original
    class Derived extends Original

    // Assignment compatibility
    val original: Original = new Derived

    // Covariance
    // Example: class List[+T]
    class Covariance[+T]
    val covariance: Covariance[Original] = new Covariance[Derived]

    // Invariance
    // Example: class Array[T]
    class Invariance[T]
    val invariance: Invariance[Original] = new Invariance[Original]

    // Contravariance
    // Example: It's complicated
    class Contravariance[-T]
    val contravariance: Contravariance[Derived] = new Contravariance[Original]
}