import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val (a, b) = readln().fold(0 to 0) { (a, b), c ->
        when (c) {
            'N' -> a + 1 to b
            'S' -> a - 1 to b
            'E' -> a to b + 1
            'W' -> a to b - 1
            else -> a to b
        }
    }
    println(abs(a) + abs(b))
}