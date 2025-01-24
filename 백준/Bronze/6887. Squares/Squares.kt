import kotlin.math.sqrt

fun main() {
    print(
        "The largest square has side length %d."
            .format(sqrt(readln().toDouble()).toInt())
    )
}