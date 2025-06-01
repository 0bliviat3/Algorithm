fun main() {
    val n = readln().toInt()

    print(
        List(n) {
            var sum = readln().toInt()
            val m = readln().toInt()
            sum += List(m) {
                val (a, b) = readln()
                    .split(" ")
                    .map { it.toInt() }
                a * b
            }.sum()
            sum
        }.joinToString("\n")
    )

}