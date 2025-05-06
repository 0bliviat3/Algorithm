import kotlin.math.abs

fun main() {
    val n = readln().toInt()

    print(
        List(n) {
            val (a, b) = readln()
                .split(" ")
                .map { it.toDouble() }

            "%.1f".format(abs(a - b))

        }.joinToString("\n")
    )
}