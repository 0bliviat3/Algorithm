fun main() {
    val result = generateSequence { readln().toInt().takeIf { it != 0 } }
        .map { getMax(readln()) }
        .joinToString(System.lineSeparator())

    print(result)
}

fun getMax(input: String): Int = input
    .split(" ")
    .map { it.toInt() }
    .windowed(3) { it.sum() }.max()