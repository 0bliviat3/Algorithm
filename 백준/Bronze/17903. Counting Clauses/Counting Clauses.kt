fun main() {
    val n = readln()
        .split(" ")
        .map { it.toInt() }
        .first()

    print(
        when {
            n < 8 -> "unsatisfactory"
            else -> "satisfactory"
        }
    )
}