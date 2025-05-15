fun main() {
    val word = "SciComLove"
    print(
        readln()
            .filterIndexed { idx, c -> word[idx] != c }
            .count()
    )
}