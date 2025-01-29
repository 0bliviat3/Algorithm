fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toInt() }

    val min = arr.min()
    var max = arr.max()

    print(
        if (min == max) {
            min.times(2)
        } else {
            min.plus(min + 1)
        }
    )
}