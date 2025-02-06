fun main() {
    val arr = readln().toCharArray()
    val ans = StringBuilder()
    var now = arr[0]
    var point = 0

    while (point < arr.size) {
        now = arr[point]
        ans.append(now)
        point += (now.code - 'A'.code + 1)
    }

    print(ans)
}