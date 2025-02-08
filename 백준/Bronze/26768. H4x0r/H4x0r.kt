fun main() {
    val map = mapOf(
        "a" to "4",
        "e" to "3",
        "i" to "1",
        "o" to "0",
        "s" to "5"
    )

    val ans = StringBuilder()

    readln()
        .toCharArray()
        .forEach {
        if (map.containsKey(it.toString())) {
            ans.append(map[it.toString()])
        } else {
            ans.append(it)
        }
    }
    print(ans)
}