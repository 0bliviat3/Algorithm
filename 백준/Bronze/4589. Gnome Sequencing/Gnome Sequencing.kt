fun main() {
    val n = readln().toInt()

    val ans = StringBuilder()

    ans.append("Gnomes:\n")

    repeat(n) {
        val arr = readln()
            .split(" ")
            .map { it.toInt() }
        if (isSorted(arr)) {
            ans.append("Ordered\n")
        } else {
            ans.append("Unordered\n")
        }
    }

    print(ans)
}

fun isSorted(arr: List<Int>): Boolean {
    val asc = arr.sorted()
    val desc = asc.reversed()

    return arr.zip(asc).all { (x, y) -> x == y } || arr.zip(desc).all { (x, y) -> x == y }
}