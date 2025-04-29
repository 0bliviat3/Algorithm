fun main() {
    val n = readln().toInt()

    print(
        List(n) {
            val arr = readln()
            listOf(arr, findTwins(
                arr.split(" ")
                    .filter { it == "17" || it == "18" }
            )).joinToString ("\n")
        }.joinToString("\n\n")
    )
}

fun findTwins(list: List<String>): String {
    return if (list.size == 2) {
        "both"
    } else if (list.isEmpty()) {
        "none"
    } else if (list.first() == "17") {
        "zack"
    } else {
        "mack"
    }
}