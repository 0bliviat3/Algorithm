fun main() {
    val (x , n) = readln()
        .split(" ")
        .map { it.toInt() }

    var now = x
    repeat(n) {
        if (now % 2 == 1) {
            now = (now * 2) xor 6
        } else {
            now = (now / 2) xor 6
        }
    }

    print(now)
}