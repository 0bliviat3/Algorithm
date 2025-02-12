fun main() {
    var n = readln().toInt()
    val ans = StringBuilder()
    while (n-- > 0) {
        ans.append(
            readln().split(" ").minOfOrNull { it.toInt() }
        ).append('\n')
    }
    print(ans)
}