fun main() {
    val n = readln().toInt()
    var flag = true
    repeat(3) {
        if (!readln().split(" ").contains("7")) {
            flag = false
        }
    }

    print(
        if (flag) {
            777
        } else {
            0
        }
    )
}