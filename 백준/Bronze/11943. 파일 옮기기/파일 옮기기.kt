import kotlin.math.min

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val (c, d) = readln().split(" ").map { it.toInt() }

    print(min((a + d), (b + c)))
}