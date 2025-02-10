import kotlin.math.abs

fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toInt() }

    val max = arr.max()
    val min = arr.min()

    print(abs(arr.sum() - 2 * (max + min)))
}