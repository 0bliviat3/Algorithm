fun main() {
    val (x, y) = readln()
        .split(" ")
        .map { it.toInt() }

    print(
        makeRepunit(x) + makeRepunit(y)
    )
}

fun makeRepunit(n: Int): Int = List(n) { 1 }.joinToString("").toInt()