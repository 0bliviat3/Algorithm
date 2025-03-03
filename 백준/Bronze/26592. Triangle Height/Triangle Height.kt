fun main() {
    val n = readln().toInt()
    val ans = StringBuilder()
    repeat(n) {
        val (a, b) = readln()
            .split(" ")
            .map { it.toDouble() }

        val h = a * 2 / b

        ans.append("The height of the triangle is %.2f units\n".format(h))
    }

    print(ans)
}