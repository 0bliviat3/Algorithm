fun main() {
    val n = readln().toInt()
    val arr = readln()
        .split(" ")
        .map { it.toInt() }

    var sum = arr[0]
    var cnt = arr[0]
    for (i in 1..<arr.size) {
        if (arr[i] == 1) {
            cnt++
        } else {
            cnt = 0
        }
        sum += cnt
    }

    print(sum)
}