import kotlin.math.min

fun main() {
    val money = readln().toInt()
    var min = 3
    repeat(3) {
        val now = readln().toInt()
        if (now <= money) {
            min = min(min, it)
        }
    }

    print(
        when(min) {
            0 -> "Watermelon"
            1 -> "Pomegranates"
            2 -> "Nuts"
            else -> "Nothing"
        }
    )
}