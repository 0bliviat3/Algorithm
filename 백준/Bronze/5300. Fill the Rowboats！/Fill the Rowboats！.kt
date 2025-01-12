fun main() {
    val ans = StringBuilder()

    val n = readln().toInt()

    for (i in 1 .. n) {
        ans.append(i).append(" ")
        if (i % 6 == 0) {
            ans.append("Go! ")
        }
    }

    if (n % 6 != 0) {
        ans.append("Go!")
    }

    print(ans)
}