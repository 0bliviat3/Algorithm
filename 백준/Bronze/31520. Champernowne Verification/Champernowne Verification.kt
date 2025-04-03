fun main() {
    val n = readln()
    val length = n.length

    var i = 1
    val champernowen = StringBuilder().append(i++)

    while (champernowen.length < length) {
        champernowen.append(i)
        i++
    }

    print(
        if (champernowen.toString() == n) {
            --i
        } else {
            -1
        }
    )
}