fun main() {
    val n = readln().toInt()
    val ans = StringBuilder()
    repeat(n) {
        ans.append(convertString(it + 1))
            .append('\n')
    }

    print(ans)
}

fun convertString(number: Int): String {
    return when {
        number % 7 == 0 && number % 11 == 0 -> "Wiwat!"
        number % 7 == 0 -> "Hurra!"
        number % 11 == 0 -> "Super!"
        else -> number.toString()
    }
}