fun main() {
    val list = List(5) {
        readln()
            .split(" ")
            .sumOf { it.toInt() }
    }

    val max = list.max()
    val idx = list.indexOf(max) + 1
    print("$idx $max")
}