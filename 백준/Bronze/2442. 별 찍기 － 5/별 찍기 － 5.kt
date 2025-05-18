fun main() {
    val n = readln().toInt()
    val ans = StringBuilder()
    for (i in 1..n) {
        for (j in 1..n - i) {
            ans.append(' ')
        }
        for (j in 1..<2 * i) {
            ans.append('*')
        }
        ans.append('\n')
    }

    print(ans)
}