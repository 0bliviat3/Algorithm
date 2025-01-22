fun main() {

    var n = readln().toInt()
    val ans = StringBuilder();

    while (n-- > 0) {
        val arr = readln()
            .split(" ")
            .map { it.toInt() }

        ans.append(
            if (
                arr
                    .zip(arr.reversed())
                    .any { (a, b) -> a < 2 && b <= 2 }
                ) {
                "Yes\n"
            } else {
                "No\n"
            }
        )
    }

    print(ans)
}