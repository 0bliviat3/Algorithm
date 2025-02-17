fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toInt() }

    print(
        when {
            arr[0] < arr[1] -> arr[1]
            arr[0] in arr[1]..arr[2] -> arr[0]
            else -> arr[2]
        }
    )
}