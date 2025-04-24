fun main() {
    val n = readln().toInt()

    print(
        List(n) {
            getPlace(readln())
        }.joinToString("\n")
    )
}

fun getPlace(input: String): String {
    val arr = input
        .split(" ")
        .map { it.toLong() }

    val erc = arr[0] * arr[1]
    val tpt = arr[2] * arr[3]

    return when {
        erc < tpt -> "Eurecom"
        erc > tpt -> "TelecomParisTech"
        else -> "Tie"
    }
}