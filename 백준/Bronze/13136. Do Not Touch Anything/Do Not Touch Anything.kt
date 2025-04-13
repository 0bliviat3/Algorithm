fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toLong() }

    print(
        mod(arr[0], arr[2]) * mod(arr[1], arr[2])
    )
}

fun mod(a: Long, b: Long): Long {
    val c = a / b
    if (a % b == 0L) {
        return c
    }
    return c + 1
}