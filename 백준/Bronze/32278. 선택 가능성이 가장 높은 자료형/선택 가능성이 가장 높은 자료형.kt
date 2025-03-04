fun main() {
    val n = readln().toLong()

    print(
        when {
            n > Int.MAX_VALUE || n < Int.MIN_VALUE -> "long long"
            n > Short.MAX_VALUE || n < Short.MIN_VALUE -> "int"
            else -> "short"
        }
    )
}