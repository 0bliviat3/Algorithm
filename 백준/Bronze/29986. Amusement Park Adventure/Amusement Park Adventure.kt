fun main() {
    val (n, high) = readln()
        .split(" ")
        .map { it.toInt() }

    print(
        readln()
            .split(" ")
            .filter { it.toInt() <= high }
            .size
    )
}