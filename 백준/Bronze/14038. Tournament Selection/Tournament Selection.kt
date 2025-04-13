fun main() {
    var cnt = 0
    repeat(6) {
        if (readln() == "W") {
            cnt++
        }
    }

    print(
        when {
            cnt > 4 -> 1
            cnt > 2 -> 2
            cnt > 0 -> 3
            else -> -1
        }
    )
}