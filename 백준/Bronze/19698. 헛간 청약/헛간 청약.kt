fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toInt() }

    val max: Int = (arr[1] / arr[3]) * (arr[2] / arr[3])

    print(
        when {
            max > arr[0] -> arr[0]
            else -> max
        }
    )
}