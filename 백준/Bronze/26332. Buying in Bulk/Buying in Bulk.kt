fun main() {
    val n = readln().toInt()
    val ans = StringBuilder();
    repeat(n) {
        val(a, b) = readln().split(" ").map { it.toInt() }
        ans.append("$a $b\n${a * b - (a - 1) * 2}\n")
    }
    print(ans)
}