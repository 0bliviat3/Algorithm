fun main() {
    val (n, high) = readln()
        .split(" ")
        .map { it.toInt() }

    print(
        readln()
            .split(" ")
            .count { it.toInt() <= high }
    )
}