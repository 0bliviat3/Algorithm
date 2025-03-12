import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val ans = StringBuilder()
    repeat(n) {
        ans.append("${getCount(readln())}\n")
    }

    print(ans)
}

fun getCount(value: String): Int {
    val (a, b) = value.fold(0 to 0) { (a, b), now ->
        when {
            now == 'a' -> a + 1 to b
            else -> a to b + 1
        }
    }

    return min(a, b)
}