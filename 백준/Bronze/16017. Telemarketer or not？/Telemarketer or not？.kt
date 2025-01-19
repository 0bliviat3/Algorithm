fun main() {

    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val d = readln().toInt()

    print(
        when {
            a != 8 && a != 9 -> "answer"
            d != 8 && d != 9 -> "answer"
            b != c -> "answer"
            else -> "ignore"
        }
    )
}