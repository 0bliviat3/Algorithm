fun main() {
    val a = readln().toInt()
    val b = readln().toInt()

    print(
        when ((a + b) % 12) {
            0 -> 12
            else -> (a + b) % 12
        }
    )
}