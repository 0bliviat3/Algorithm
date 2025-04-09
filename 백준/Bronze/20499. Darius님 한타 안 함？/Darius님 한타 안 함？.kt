fun main() {
    val arr = readln()
        .split("/")
        .map { it.toInt() }

    print(
        when {
            arr[0] + arr[2] < arr[1] || arr[1] == 0 -> "hasu"
            else -> "gosu"
        }
    )
}