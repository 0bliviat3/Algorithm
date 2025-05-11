import kotlin.math.ceil

fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toDouble()}

    print(
        ceil(arr[0] / (arr[2] - arr[1])).toInt()
    )
}