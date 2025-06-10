fun main() {
    val n = readln().toInt()
    print(
        List(n) {
            getDist(readln())
        }.joinToString("\n")
    )
}

fun getDist(input: String): Int {
    val arr = input
        .split(" ")
        .map { it.toInt() }

    val gap = arr[2] - arr[1]
    if (gap < 0) {
        return 0
    }
    return gap * ((arr[0] shl 1) - 1)
}