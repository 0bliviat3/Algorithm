fun main() {
    val date = readln()
        .split("-")
        .map { it.toInt() }

    print(
        if (date[1] == 9 && date[2] <= 16) {
            "GOOD"
        } else if (date[1] < 9) {
            "GOOD"
        } else {
            "TOO LATE"
        }
    )
}