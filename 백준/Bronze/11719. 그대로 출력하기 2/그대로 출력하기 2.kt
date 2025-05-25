import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val text = StringBuilder()
    val reader = BufferedReader(InputStreamReader(System.`in`))

    while (true) {
        val now = reader.readLine() ?: break
        text.append("$now\n")
    }
    println(text)
}