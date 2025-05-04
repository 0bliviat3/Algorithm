fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toLong() }

    if (arr.count{ it % 2 == 0L } > 0) {
        println(0)
    } else {
        println(arr.min())
    }
}