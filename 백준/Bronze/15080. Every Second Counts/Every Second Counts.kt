fun main() {

    val start = convertTime(readln())
    val end = convertTime(readln())

    val ans =
        if (end < start) {
            timeToSeconds(24, 0, 0) - start + end
        } else {
            end - start
        }

    print(ans)
}

fun convertTime(input: String): Int {
    val arr = input.split(" : ").map { it.toInt() }
    return timeToSeconds(arr[0], arr[1], arr[2])
}

private fun timeToSeconds(hours: Int, minutes: Int, seconds: Int): Int {
    return hours * 3600 + minutes * 60 + seconds
}