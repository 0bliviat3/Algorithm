fun main() {
    val a = getScore(readln())
    val b = getScore(readln())

    print(
        when {
            a == b -> "NO SCORE"
            a > b -> "1 ${a - b}"
            else -> "2 ${b - a}"
        }
    )
}

fun getScore(input: String): Int {
    val (h1, b1) = input
        .split(" ")
        .map { it.toInt() }

    return h1 * 3 + b1
}