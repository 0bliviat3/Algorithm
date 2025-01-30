fun main() {
    val n = readln().toInt()

    val flag: Boolean = readln()
        .toCharArray()
        .distinct()
        .size == 1

    print(
        if (flag) {
            "Yes"
        } else {
            "No"
        }
    )

}