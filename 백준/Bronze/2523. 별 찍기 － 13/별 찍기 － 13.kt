fun main() {
    val n = readln().toInt()

    val list = List(n) {
        var now = ""
        for (i in 0..it) {
            now += "*"
        }
        now
    }

    print(
        list.joinToString("\n") + "\n"
                + list.reversed()
                    .subList(1, n)
                    .joinToString("\n")
    )
}