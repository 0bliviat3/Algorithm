fun main() {
    val input = readln()

    print(
        input.filterIndexed { i, c ->
            if (i == 0) {
                true
            } else {
                input[i - 1] != c
            }
        }
    )
}