fun main() {
    val n = readln().toInt()

    print(
        List(n) {
            val (input, output) = readln().split(" ")
            if (input == output) {
                "OK"
            } else {
                "ERROR"
            }
        }.joinToString("\n")
    )
}