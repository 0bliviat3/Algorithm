fun main() {
    readln()
    print(
        readln().map {
            when (it) {
                'J' -> 'O'
                'O' -> 'I'
                else -> 'J'
            }
        }.joinToString("")
    )

}