fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toInt() }
        .sorted()

    print(arr[1])
}