fun main() {
    val ADD = 60;
    val start = readln().toInt()
    val end = readln().toInt()

    val ans = StringBuilder()

    var now = start

    while (now <= end) {
        ans.append("All positions change in year $now\n")
        now += ADD
    }

    print(ans)

}