fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toInt() }

    val ans = convertMinute(arr[0], arr[1], arr[2]) - convertMinute(11, 11, 11)

    print(
        when {
            ans < 0 -> -1
            else -> ans
        }
    )
}

fun convertMinute(day: Int, time: Int, minute: Int): Int {
    return day * 24 * 60 + time * 60 + minute
}