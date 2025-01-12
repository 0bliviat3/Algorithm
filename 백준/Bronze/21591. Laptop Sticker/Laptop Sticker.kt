fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toInt() }

    print(
        if (arr[0] >= arr[2] + 2 && arr[1] >= arr[3] + 2) {
            1
        } else {
            0
        }
    )
}