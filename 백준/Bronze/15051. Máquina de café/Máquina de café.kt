fun main() {
    val arr = List(3) { readln().toInt() }

    print(
        listOf(
            arr[1] * 2 + arr[2] * 4,
            arr[0] * 2 + arr[2] * 2,
            arr[0] * 4 + arr[1] * 2
        ).min()
    )

}