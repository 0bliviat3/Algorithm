fun main() {
    val set = mutableSetOf('l', 'k', 'p')
    var cnt = 0
    repeat(3) {
        if (set.remove(readln().toCharArray()[0])) {
            cnt++
        }
    }

    print(
        when {
            cnt == 3 -> "GLOBAL"
            else -> "PONIX"
        }
    )
}