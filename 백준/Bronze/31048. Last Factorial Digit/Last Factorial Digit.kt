fun main() {
    var n = readln().toInt()
    val ans = StringBuilder()

    while (n-- > 0) {
        ans.append(
            when(readln().toInt()) {
                1 -> 1
                2 -> 2
                3 -> 6
                4 -> 4
                else -> 0
            }
        ).append('\n')
    }

    print(ans)

}