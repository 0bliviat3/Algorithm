fun main() {
    val set = readln()
        .split(" ")
        .map { it.toLong() }
        .toMutableSet()

    set.remove(set.max())
    set.remove(set.min())

    print(set.first())
}