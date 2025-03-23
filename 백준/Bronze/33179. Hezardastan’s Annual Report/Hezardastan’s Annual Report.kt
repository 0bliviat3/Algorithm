import kotlin.math.ceil

fun main() {
    val n = readln().toInt()
    val sum = readln()
        .split(" ")
        .sumOf {
            ceil(it.toDouble() / 2).toInt()
        }

    print(sum)
}