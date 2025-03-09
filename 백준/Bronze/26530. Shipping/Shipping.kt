fun main() {
    var n = readln().toInt()
    val ans = StringBuilder()
    while (n-- > 0) {
        val m = readln().toInt()
        var sum = 0.0
        repeat(m) {
           val arr = readln().split(" ")
           sum += arr[1].toDouble() * arr[2].toDouble()
        }
        ans.append("$%.2f\n".format(sum))
    }
    println(ans)
}