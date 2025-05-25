fun main() {
    val line = readln()
    val ans = StringBuilder()
    for (i in line.indices step 10) {
        val end = minOf(i + 10, line.length)
        ans.append("${line.substring(i, end)}\n")
    }
    print(ans)
}