fun main() {
    val (n, m) = readln()
        .split(" ")
        .map { it.toInt() }

    print(
        if (n > 7) {
            n - 7
        } else {
            getSunday(n , m)
        }
    )
}

fun getSunday(n: Int, m: Int): Int {
    val endDay = listOf(21, 22, 23, 24)
    return endDay.first { m + 7 == n + it } + n
}