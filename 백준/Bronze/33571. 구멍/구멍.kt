fun main() {
    val set = mutableSetOf('a', 'A', 'b', 'D', 'd', 'e', 'g', 'O', 'o', 'p', 'P', 'q', 'Q', 'R', '@')
    var sum = 0
    readln().forEach {
        if (set.contains(it)) {
            sum++
        } else if (it == 'B') {
            sum += 2
        }
    }

    print(sum)
}