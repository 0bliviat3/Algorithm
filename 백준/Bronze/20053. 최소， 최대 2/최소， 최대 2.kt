fun main() {
    val t = readln().toInt()

    print(
        List (t) {
            readln()
            val arr = readln()
                .split(" ")
                .map { it.toInt() }

            "${arr.min()} ${arr.max()}"
        }.joinToString("\n")
    )
}