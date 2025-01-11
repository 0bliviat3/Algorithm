import kotlin.math.abs

fun main() {
    val (n, m, k) = readln()
        .split(" ")
        .map { it.toInt() }

    println(n - abs(m - k))
}