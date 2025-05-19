fun main() {
    val (n, k) = readln()
        .split(" ")
        .map { it.toInt() }
    var save = 0
    var now = 0
    print(
        List(n) {
            when (readln()) {
                "save" -> save = now
                "load" -> now = save
                "shoot" -> now--
                else -> now += k
            }
            now
        }.joinToString("\n")
    )
}