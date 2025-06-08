fun main() {
    val arr = List(7) { readln().toInt() }
        .filter { it % 2 == 1 }

    print(
        if (arr.isEmpty()) {
            -1
        } else {
            "${arr.sum()}\n${arr.min()}"
        }
    )
}