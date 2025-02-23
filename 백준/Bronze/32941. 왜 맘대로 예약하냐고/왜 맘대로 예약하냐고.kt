fun main() {
    val (t, x) = readln()
        .split(" ")
        .map { it.toInt() }

    val n = readln().toInt()
    var flag = true;

    repeat(n) {
        readln()
        val yes = readln()
            .split(" ")
            .count { it.toInt() == x } == 1

        if (!yes) {
            flag = false
        }
    }

    println(
        when (flag) {
            true -> "YES"
            else -> "NO"
        }
    )
}