fun main() {
    val (a, b) = readln()
        .split(" ")
        .map { it.toInt() }

    print("${b + 1} ${a * b + 1}")
}