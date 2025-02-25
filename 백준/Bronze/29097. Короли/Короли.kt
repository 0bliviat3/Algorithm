fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toInt() }

    val map = mapOf(
        "Joffrey" to arr[0] * arr[3],
        "Robb" to arr[1] * arr[4],
        "Stannis" to arr[2] * arr[5]
    )

    val max = map.values.maxOrNull()

    map.filter { it.value == max }
        .keys
        .sorted().forEach { print("$it ") }
}