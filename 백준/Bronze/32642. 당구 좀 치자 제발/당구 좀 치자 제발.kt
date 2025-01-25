fun main() {
    val n = readln().toInt()

    var now: Long = 0;
    var ans: Long = 0;

    val arr:List<Long> = readln()
        .split(" ")
        .map {
            if (it.toInt() == 0) {
                -1
            } else {
                1
            }
        }

    for (i in 0..< n) {
        now += arr[i]
        ans += now
    }

    print(ans)
}