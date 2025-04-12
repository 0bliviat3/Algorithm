fun main() {
    val (a, b) = readln()
        .split(" ")
        .map { it.toDouble() }
    
    val x = (100 - b) * (a / 100)
    
    print(
        if (x >= 100) {
            0
        } else {
            1
        }
    )
}