fun main() {

    val input = readln().toSet()
    val missing = ('A'..'Z')
        .first { it !in input }

    print(missing)
}