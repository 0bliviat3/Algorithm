import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val p = readln().toInt()

    println(discount(n, p))
}

fun discount(n: Int, p: Int): Int {
    val discountArr: List<(Int) -> Int> = listOf(
        { it },
        {
            if (it - 500 < 0) {
                0
            } else {
                it - 500
            }
        },
        { it / 100 * 90 },
        {
            if (it - 2000 < 0) {
                0
            } else {
                it - 2000
            }
        },
        { it / 100 * 75 }
    )

    val range =
        if (n / 5 > 4) {
            4
        } else {
            (n / 5)
        }

    var min = p
    for (i in 0..range) {
        min = min(min, discountArr[i](p))
    }

    return min
}