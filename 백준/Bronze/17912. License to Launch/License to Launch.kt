fun main() {
    val n = readln().toInt()
    val arr = readln()
        .split(" ")
        .map { it.toInt() }
    val min = arr.min()

    println(
        arr.indexOf(min)
    )
}