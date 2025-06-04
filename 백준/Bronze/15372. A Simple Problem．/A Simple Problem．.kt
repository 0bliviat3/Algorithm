fun main() {
    val n = readln().toInt()

    print(
        List(n) {
            val now = readln().toLong()
            now * now
        }.joinToString("\n")
    )
}