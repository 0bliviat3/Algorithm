package boj03

fun main() {
    print(
        List(3) {
            splitTimeCard(calculateTime(readln()))
        }.joinToString("\n")
    )
}

fun calculateTime(input: String): Int {
    val arr = input
        .split(" ")
        .map { it.toInt() }

    val start = arr[0] * 60 * 60 + arr[1] * 60 + arr[2]
    val end = arr[3] * 60 * 60 + arr[4] * 60 + arr[5]

    return end - start
}

fun splitTimeCard(time: Int): String {
    val h = time / (60 * 60)
    val m = (time - h * 60 * 60) / 60
    val s = time % 60

    return "$h $m $s"
}