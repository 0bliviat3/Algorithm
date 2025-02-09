fun main() {
    val ans = StringBuilder()

    while (true) {
        val str = readlnOrNull()
        if (str.isNullOrEmpty()) {
            break
        }
        ans.append(str).append('\n')
    }

    print(ans)
}