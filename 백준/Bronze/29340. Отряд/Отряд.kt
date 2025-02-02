import kotlin.math.max

fun main() {
    val first = readln()
        .toCharArray()
        .map { it.code - '0'.code }
    val second = readln()
        .toCharArray()
        .map { it.code - '0'.code }
    val ans = StringBuilder()

    for (i in first.indices) {
        val max = max(first[i], second[i])
        ans.append(max)
    }

    print(ans)
}