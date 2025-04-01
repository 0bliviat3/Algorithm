fun main() {
    val arr = readln().split(" ").map { it.toInt() }
    val sum = calculateOverTime(convertMinute(arr[0], arr[1]), convertMinute(arr[2], arr[3]), 24 * 60)

    print("$sum ${countCircle(sum)}")
}

fun calculateOverTime(t1: Int, t2: Int, attention: Int): Int {
    if (t1 <= t2) {
        return t2 - t1
    }
    return attention - t1 + t2
}

fun countCircle(minute: Int): Int = minute / 30

fun convertMinute(time: Int, minute: Int): Int = time * 60 + minute


