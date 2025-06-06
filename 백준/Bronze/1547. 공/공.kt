fun main() {
    val n = readln().toInt()
    val arr = mutableListOf(true, false, false)

    repeat(n) {
        val (a, b) = readln()
            .split(" ")
            .map { it.toInt() - 1 }
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }

    println(arr.indexOf(true) + 1)
}