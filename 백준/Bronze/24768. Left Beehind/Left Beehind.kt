fun main() {

    val ans = StringBuilder()
    while (true) {
        var now = readln()
        if (now == "0 0") {
            break
        }
        val (a, b) = now
            .split(" ")
            .map { it.toInt() }
        ans.append(
            when {
                a + b == 13 -> "Never speak again.\n"
                a > b -> "To the convention.\n"
                b > a -> "Left beehind.\n"
                else -> "Undecided.\n"
            }
        )
    }

    print(ans)

}