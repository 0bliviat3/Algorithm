fun main() {

    val ans = StringBuilder()

    while (true) {
        val (x, y) = readln()
            .split(" ")

        ans.append(sortPoint(x, y)).append('\n')

        if (x == "0" && y == "0") {
            break
        }
    }

    print(ans)
}

fun sortPoint(x: String, y: String): String {
    if (x == "0" || y == "0") {
        return "AXIS"
    }
    return if (x[0] != '-') {
        if (y[0] != '-') {
            "Q1"
        } else {
            "Q4"
        }
    } else  {
        if (y[0] == '-') {
            "Q3"
        } else {
            "Q2"
        }
    }
}