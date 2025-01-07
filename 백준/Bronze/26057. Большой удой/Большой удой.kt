fun main() {
    var l = readln().toInt()
    var t = readln().toInt()

    l -= t
    t -= l

    println(t)
}