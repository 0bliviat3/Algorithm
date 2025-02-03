import kotlin.math.pow

fun main() {
    val ans = StringBuilder()
    var input: String
    while (readln().also { input = it } != "0") {
        ans.append("%.2f\n".format(getTotal(input.toDouble())))
    }

    print(ans)
}

fun getTotal(number: Double): Double {
    var total = 0.0

    for (i in 0 .. 4) {
        total += number.pow(i.toDouble())
    }

    return total
}