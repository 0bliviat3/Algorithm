fun main() {
    val n = readln().toInt()

    print(
        List(n) {
            readln()
                .split(",")
                .sumOf { it.toInt() }
        }.joinToString("\n")
    )
}