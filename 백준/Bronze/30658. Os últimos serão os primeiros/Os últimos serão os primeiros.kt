fun main() {
    val ans = StringBuilder()
    while (true) {
        val n = readln().toInt()
        if (n == 0) {
            break
        }
        ans.append(
            List(n) {
                readln()
            }.reversed().joinToString("\n")
        ).append("\n0\n")
    }
    print(ans)
}