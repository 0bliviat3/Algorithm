fun main() {
    println(
        readln()
            .split(" ")
            .minOfOrNull { it.toInt() }
    )
}