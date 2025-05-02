fun main() {
    val n = readln().toInt()

    print(
        List(n) {
            countU(readln())
        }.joinToString("\n")
    )
}

fun countU(str: String): Int {
    var cnt = 0
    for (c in str) {
        if (c != 'U') {
            break;
        }
        cnt++
    }
    return cnt;
}