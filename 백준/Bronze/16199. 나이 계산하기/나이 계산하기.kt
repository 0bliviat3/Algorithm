fun main() {
    val arr1 = readln()
        .split(" ")
        .map { it.toInt() }

    val arr2 = readln()
        .split(" ")
        .map { it.toInt() }

    val yearGap = arr2[0] - arr1[0]

    print("${passBirthDay(yearGap, arr1[1], arr1[2], arr2[1], arr2[2])}\n${yearGap + 1}\n$yearGap")



}

fun passBirthDay(yearGap: Int, month: Int, day: Int, dateMonth: Int, dateDay: Int): Int {
    if ((month * 100 + day) <= (dateMonth * 100 + dateDay)) {
        return yearGap
    }
    return yearGap - 1
}