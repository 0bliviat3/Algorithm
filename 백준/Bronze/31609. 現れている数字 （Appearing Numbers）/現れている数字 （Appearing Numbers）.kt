fun main() {
    readln()
    println(
        readln()
            .split(" ")
            .map { it.toInt() }
            .distinct()
            .sorted()
            .joinToString("\n")
    )
}