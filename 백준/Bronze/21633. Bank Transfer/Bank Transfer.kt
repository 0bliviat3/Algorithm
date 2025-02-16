fun main() {
    val sum: Double = 25.0
    val k = readln().toDouble() / 100

    val ans = when (sum + k) {
        in 0.0..100.0 -> 100.0
        in 2000.0..Double.MAX_VALUE -> 2000.0
        else -> sum + k
    }

    println("%.2f".format(ans))
}