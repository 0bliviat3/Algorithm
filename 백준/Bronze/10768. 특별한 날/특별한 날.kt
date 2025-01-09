fun main() {

    val a = readln().toInt()
    val b = readln().toInt()

    print(
        when {
            a > 2 -> "After"
            a == 2 && b == 18 -> "Special"
            a == 2 && b > 18 -> "After"
            else -> "Before"
        }
    )

}