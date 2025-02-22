fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toInt() }

    print(arr.sum() - arr.min() + 1)
}