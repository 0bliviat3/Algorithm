import kotlin.math.PI

fun main() {
    val (a1, p1) = readPair(readln())
    val (r1, p2) = readPair(readln())

    val p = a1 / p1
    val c = r1 * r1 * PI / p2

    print(
        when {
            p > c -> "Slice of pizza"
            else -> "Whole pizza"
        }
    )
}

fun readPair(input: String) = input
    .split(" ")
    .map { it.toDouble() }