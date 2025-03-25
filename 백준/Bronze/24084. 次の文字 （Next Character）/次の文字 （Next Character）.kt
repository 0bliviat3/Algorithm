fun main() {
    readln()
    val s = readln()

    println(
        s.zipWithNext()
            .filter { it.second == 'J' }
            .joinToString(System.lineSeparator()) { it.first.toString() }
    )
}