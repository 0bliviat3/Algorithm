fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toInt() }

    val sec = getSec(arr[0], arr[1], arr[2]) + readln().toInt()
    print(setClock(sec))
}

fun getSec(hour: Int, minute: Int, sec: Int): Int  = hour * 60 * 60 + minute * 60 + sec
fun setClock(time: Int): String {
    val sec = time % (60 * 60 * 24)
    val h = sec / (60 * 60)
    val m = (sec - (h * 60 * 60)) / 60
    val s = sec - h * 60 * 60 - m * 60

    return "$h $m $s"
}