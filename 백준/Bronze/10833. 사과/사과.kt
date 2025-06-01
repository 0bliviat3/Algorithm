fun main() {
    val n = readln().toInt()
    print(
        List(n) {
            val (a, b) = readln()
                .split(" ")
                .map { it.toInt() }
            b % a
        }.sum()
    )
}