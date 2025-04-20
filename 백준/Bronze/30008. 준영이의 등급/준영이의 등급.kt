fun main() {
    val n = readln()
        .split(" ")
        .map { it.toInt() }
        .first()

    val ans = readln()
        .split(" ")
        .map { getGrade(it.toInt() * 100 / n) }
        .joinToString(" ")


    print(ans)
}

fun getGrade(p: Int): Int {
    return when {
        p <= 4 -> 1
        p <= 11 -> 2
        p <= 23 -> 3
        p <= 40 -> 4
        p <= 60 -> 5
        p <= 77 -> 6
        p <= 89 -> 7
        p <= 96 -> 8
        else -> 9
    }
}