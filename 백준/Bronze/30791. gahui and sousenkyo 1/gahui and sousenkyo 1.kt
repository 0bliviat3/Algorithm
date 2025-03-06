fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toInt() }

    val max = arr.max()

    print(arr.count { max - it <= 1000 } - 1)

}