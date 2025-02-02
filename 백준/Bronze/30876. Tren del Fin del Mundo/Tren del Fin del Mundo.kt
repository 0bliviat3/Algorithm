import kotlin.math.min

fun main() {
    var n = readln().toInt()
    var ans = Pair<Int, Int>(0, 0);
    var min = 1000

    while (n-- > 0) {
        val now = readln()
            .split(" ")
            .map { it.toInt() }

        if (min >= now[1]) {
            min = now[1]
            ans = Pair(now[0], now[1])
        }
    }

    print(
        StringBuilder()
            .append(ans.first)
            .append(" ")
            .append(ans.second)
    )
}