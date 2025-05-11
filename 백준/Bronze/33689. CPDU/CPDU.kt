fun main() {
    val n = readln().toInt()

    print(
        List(n) {
            readln()[0]
        }.count { it == 'C' }
    )
}