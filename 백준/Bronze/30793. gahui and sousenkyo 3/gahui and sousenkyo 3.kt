fun main() {
    val (a, b) = readln()
        .split(" ")
        .map { it.toDouble() }

    print(
        when {
            a / b < 0.2 -> "weak"
            a / b < 0.4 -> "normal"
            a / b < 0.6 -> "strong"
            else -> "very strong"
        }
    )
}