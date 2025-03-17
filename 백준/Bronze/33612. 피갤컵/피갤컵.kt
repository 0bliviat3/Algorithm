fun main() {
    val (startYear, startMonth) = 2024 to 8
    val cycle = 7

    val n = readln().toInt() - 1
    val totalMonths = cycle * n + startMonth

    val year = startYear + (totalMonths - 1) / 12
    val month = (totalMonths - 1) % 12 + 1

    println("$year $month")
}
