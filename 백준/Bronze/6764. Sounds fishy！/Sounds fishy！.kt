fun main() {

    val pairArr = List(4) {
        readln().toInt()
    }.windowed(2)

    print(
        when {
            readSequence(pairArr) { it[0] < it[1] } -> "Fish Rising"
            readSequence(pairArr) { it[0] > it[1] } -> "Fish Diving"
            readSequence(pairArr) { it[0] == it[1] } -> "Fish At Constant Depth"
            else -> "No Fish"
        }
    )
}

fun readSequence(
    pairArr: List<List<Int>>,
    predicate: (List<Int>) -> Boolean
): Boolean {
    return pairArr.count { predicate(it) } == pairArr.size
}