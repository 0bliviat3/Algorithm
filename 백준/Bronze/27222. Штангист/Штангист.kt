fun main() {
    val n = readln().toInt()

    val arr = readln()
        .split(" ")
        .map { it.toInt() }

    println(
        List(n) { idx ->
            val (before, after) = readln()
                .split(" ")
                .map { it.toInt() }
            val gap = after - before
            if (arr[idx] > 0 && gap > 0) {
                gap
            } else {
                0
            }
        }.sum()
    )
}