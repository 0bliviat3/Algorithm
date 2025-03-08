import kotlin.math.min

fun main() {
    val (n, m) = readln()
        .split(" ")
        .map { it.toInt() }

    var a = 0
    var b = 0

    repeat(n) {
        val arr = readln().toCharArray()
        a += arr.count { it == '0' }
        b += arr.count { it == '1' }
    }

    print(min(a, b))
}