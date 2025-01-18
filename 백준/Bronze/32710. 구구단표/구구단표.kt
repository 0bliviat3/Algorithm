fun main() {
    val n = readln().toInt()

    print(judge(n))
}

fun judge(number: Int): Int {
    
    if (number == 1) {
        return 1
    }

    for (i in 2 .. 9) {
        if (number % i == 0 && number / i <= 9) {
            return 1
        }
    }

    return 0
}