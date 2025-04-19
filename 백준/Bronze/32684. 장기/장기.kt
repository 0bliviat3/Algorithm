fun main() {
    val arr = listOf(13, 7, 5, 3, 3 ,2)

    val c = readln()
        .split(" ")
        .map { it.toInt() }
    val e = readln()
        .split(" ")
        .map { it.toInt() }

    print(
        if (merge(arr, c) < (merge(arr, e) + 1.5)) {
            "ekwoo"
        } else {
            "cocjr0208"
        }
    )
}

fun merge(list: List<Int>, list2: List<Int>): Int {
    return list.zip(list2) { a, b -> a * b }.sum()
}