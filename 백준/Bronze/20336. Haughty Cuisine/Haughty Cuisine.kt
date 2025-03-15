fun main() {
    val n = readln().toInt()

    val ans = StringBuilder()

    readln()
        .split(" ")
        .forEach { ans.append(it).append('\n') }

    print(ans)
}