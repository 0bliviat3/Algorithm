fun main() {
    val (n, a) = readln()
        .split(" ")
        .map { it.toInt() }

    print(
        readln()
            .split(" ")
            .sumOf { it.toInt() / a }
    )
}