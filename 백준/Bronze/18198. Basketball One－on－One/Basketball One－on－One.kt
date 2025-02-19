fun main() {

    val map = mutableMapOf('A' to 0, 'B' to 0)

    readln().chunked(2).forEach {
        map[it[0]] = (it[1].code - '0'.code + map[it[0]]!!)
    }

    print(
        if (map['A']!! > map['B']!!) {
            'A'
        } else {
            'B'
        }
    )
}