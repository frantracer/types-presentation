object StaticTyping extends App {
    def main() {
        var my_variable = 5
        println(my_variable)

        // Compile Error
        /*
        my_variable = "five"
        println(my_variable)
        */
    }
}
