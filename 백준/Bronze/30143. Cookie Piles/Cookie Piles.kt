fun main() {
    var t = readln().toInt()
    val ans = StringBuilder()
    while (t-- > 0) {
        ans.append(getSum(readln())).append('\n')
    }

    print(ans)
}

fun getSum(input: String): Int {
    val arr = input
        .split(" ")
        .map { it.toInt() }
        .toMutableList()

    arr[0]--

    var ret = arr[1]

    for (i in 0..<arr[0]) {
        arr[1] += arr[2]
        ret += arr[1]
    }

    return ret
}