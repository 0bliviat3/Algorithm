fun main() {
    val n = readln().toInt()
    val part = listOf(35.0, 25.0, 40.0)

    val ans = List(n) {
        val point = readln()
            .split(" ")
            .map { it.toInt() }
        val no = point.first()
        val score = point.drop(1)

        "$no ${score.sum()} ${isPass(score, part)}"
    }

    print(ans.joinToString("\n"))
}


fun isPass(point: List<Int>, part: List<Double>): String {
    if (point.zip(part).all {it.second * 0.3 <= it.first} && point.sum() >= 55) {
        return "PASS"
    }
    return "FAIL"
}