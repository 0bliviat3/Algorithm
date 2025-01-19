import java.util.StringTokenizer

fun main() {
    val arr = readln()
        .split(" ")
        .map { it.toInt() }

    val x = StringTokenizer(readln())
        .nextToken()
        .toInt()

    for (i in 0 .. 3) {
        if (arr[i] == x) {
            print(i + 1)
            return;
        }
    }
    print(0)
}