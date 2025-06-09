fun main() {
    val n = readln().toInt()

    print(
        List(n) {
            val input = readln()
            val arr = input
                .split(" ")
                .map { it.toInt() }

            val cnt = arr.count { it >= 10 }
            val message = when(cnt) {
                0 -> "zilch"
                1 -> "double"
                2 -> "double-double"
                else -> "triple-double"
            }
            "$input\n$message\n"
        }.joinToString("\n")
    )

}