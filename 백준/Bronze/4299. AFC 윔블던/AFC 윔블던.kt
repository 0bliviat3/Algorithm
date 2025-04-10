fun main() {
    val (a, b) = readln()
        .split(" ")
        .map { it.toInt() }

    val x = (a + b) / 2
    val y = a - x

    print(
        when {
            isShit(a, b) -> -1
            else -> "$x $y"
        }
    )
}

fun isShit(a: Int, b: Int): Boolean = (a + b) % 2 == 1 || b > a || a < 0 || b < 0