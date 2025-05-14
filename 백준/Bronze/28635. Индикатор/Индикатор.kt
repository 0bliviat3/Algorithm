fun main() {
    val m = readln().toInt()
    val a = readln().toInt()
    val b = readln().toInt()

    print(
        if (a <= b) {
            b - a
        } else {
            m - a + b }
    )
}