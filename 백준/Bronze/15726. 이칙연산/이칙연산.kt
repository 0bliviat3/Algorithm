import kotlin.math.max

fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toDouble() }

    val max = max(arr[0] * arr[1] / arr[2], arr[0] / arr[1] * arr[2])

    print(max.toInt())
}