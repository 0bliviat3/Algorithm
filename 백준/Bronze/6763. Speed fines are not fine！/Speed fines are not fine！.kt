fun main() {
    val a = readln().toInt()
    val b = readln().toInt()

    println(
        when (b - a) {
            in 1..20 -> "You are speeding and your fine is \$100."
            in 21..30 -> "You are speeding and your fine is \$270."
            in 31..Int.MAX_VALUE -> "You are speeding and your fine is \$500."
            else -> "Congratulations, you are within the speed limit!"
        }
    )
}