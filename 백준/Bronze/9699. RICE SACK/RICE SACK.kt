fun main() {
    val n = readln().toInt()
    val ans = StringBuilder()

    for (i in 1..n) {
        ans.append("Case #$i: ")
            .append(
                readln()
                    .split(" ")
                    .maxOfOrNull { it.toInt() }
            ).append('\n')
    }

    print(ans)
}