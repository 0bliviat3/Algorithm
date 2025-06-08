fun main() {
    val n = readln().toInt()
    print(
        List(n) {
            val arr = readln()
                .split(" ")
                .map { it.toInt() }

            val gap = arr[1] - arr[2]
            when {
                arr[0] > gap -> "do not advertise"
                arr[0] < gap -> "advertise"
                else -> "does not matter"
            }
        }.joinToString("\n")
    )
}