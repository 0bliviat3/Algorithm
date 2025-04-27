fun main() {
    val (n, x) = readln()
        .split(" ")
        .map { it.toInt() }

    val ans = readln()
        .split(" ")
        .map { it.toInt() }
        .windowed(2)
        .minOf { it.sumOf { day -> day * x } }

    print(ans)
}