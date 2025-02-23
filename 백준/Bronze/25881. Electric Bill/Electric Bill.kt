fun main() {
    val (a, b) = readln()
        .split(" ")
        .map { it.toInt() }

    val n = readln().toInt()
    val ans = StringBuilder()

    repeat(n) {
        val now = readln().toInt()

        ans.append(now).append(' ')
        if (now <= 1000) {
            ans.append(now * a)
        } else {
            ans.append(1000 * a + (now - 1000) * b)
        }
        ans.append('\n')
    }

    print(ans)
}