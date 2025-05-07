fun main() {
    val s = readln().toInt()
    val a = readln().toInt()
    val b = readln().toInt()

    val extra = if (s > a) {
        if ((s - a) % b == 0) {
            (s - a) / b * 100
        } else {
            ((s - a) / b + 1) * 100
        }
    } else {
        0
    }

    print(
        250 + extra
    )
}