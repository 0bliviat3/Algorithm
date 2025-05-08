fun main() {

    val k = readln().toInt()

    print(
        List(k) {
            val arr = readln()
                .split(" ")
                .map { it.toInt() }

            val sum = List(arr[0]) {
                val (d, v) = readln()
                    .split(" ")
                    .map { it.toInt() }

                if (arr[1] * arr[2] >= d) {
                    v
                } else {
                    0
                }
            }.sum()

            "Data Set ${it + 1}:\n$sum\n"
        }.joinToString("\n")
    )

}