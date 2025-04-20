fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toInt() }
        .reversed()

    val points = readln()
        .split(" ")
        .map { it.toInt() }
        .reversed()

    val checkArr = arr.zip(points) { a, b ->
        if (a == b) {
            2
        } else if ((a + 1) / 2 <= b) {
            1
        } else {
            0
        }
    }

    val rank = listOf('A', 'B', 'C', 'D', 'E').reversed()

    var sum = 0
    for (i in checkArr.indices) {
        sum+=checkArr[i]
        if (checkArr[i] == 2) {
            continue
        }
        break
    }

    print(rank[sum - 2])
}