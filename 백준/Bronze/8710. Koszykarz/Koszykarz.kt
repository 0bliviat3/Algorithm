fun main() {
    val arr = readln().split(" ").map { it.toInt() }

    print(
        if ((arr[1] - arr[0]) % arr[2] == 0) {
            (arr[1] - arr[0]) / arr[2]
        } else {
            (arr[1] - arr[0]) / arr[2] + 1
        }
    )

}