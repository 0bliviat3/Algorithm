fun main() {
    val set: MutableSet<Char> = linkedSetOf('U', 'A', 'P', 'C')

    readln().filter { set.remove(it) }

    print(set.joinToString(""))
}