fun main() {
    val n = readln().toInt()
    val ans = StringBuilder()

    repeat(n) {
        ans.append("${readln().length}\n")
    }

    print(ans)
}