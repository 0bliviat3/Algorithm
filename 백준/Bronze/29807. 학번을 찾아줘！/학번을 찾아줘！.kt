fun main() {
    val n = readln().toInt()
    val input = readln().split(" ")

    val points = List(5) {idx ->
        if (idx < n) {
            input[idx].toInt()
        } else {
            0
        }
    }

    val sum1 = if (points[0] > points[2]) {
        (points[0] - points[2]) * 508
    } else {
        (points[2] - points[0]) * 108
    }

    val sum2 = if (points[1] > points[3]) {
        (points[1] - points[3]) * 212
    } else {
        (points[3] - points[1]) * 305
    }

    val sum3 = points[4] * 707

    println((sum1 + sum2 + sum3) * 4763)
}