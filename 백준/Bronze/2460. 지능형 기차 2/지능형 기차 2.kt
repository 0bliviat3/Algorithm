import kotlin.math.max

fun main() {
    var max = 0
    var now = 0
    repeat(10) {
        val (outer, inner) = readln()
            .split(" ")
            .map { it.toInt() }
        now -= outer
        now += inner
        max = max(now, max)
    }
    print(max)
}