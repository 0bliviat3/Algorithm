fun main() {
    val (w, b) = readln()
        .split(" ")
        .map { it.toLong() }

    if (w >= b) {
        println(b)
    } else {
        println(w + 1)
    }
}