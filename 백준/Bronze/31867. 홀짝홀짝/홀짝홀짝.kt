fun main() {
    val n = readln().toInt()

    var odd = 0;
    var even = 0;

    val arr = readln().toCharArray().forEach {
        if ((it.code - '0'.code) % 2 == 0) {
            even++
        } else {
            odd++
        }
    }

    print(
        when {
            even == odd -> -1
            even > odd -> 0
            else -> 1
        }
    )
}