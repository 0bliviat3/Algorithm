import kotlin.math.min

fun main() {
    val n = readln().toInt()
    var min = Int.MAX_VALUE
    repeat(n) {
        val now = readln()
            .split(" ")
            .sumOf { it.toInt() }

        min = min(min, now)
    }

    print(min)
}