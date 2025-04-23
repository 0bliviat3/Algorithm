fun main() {
    val ans = StringBuilder()
    while(true) {
        val name = readlnOrNull().orEmpty()
        if (name.isEmpty()) {
            break
        }
        ans.append(convertName(name)).append('\n')
    }
    print(ans)
}

fun convertName(name: String): String {
    return name.map {
        when (it) {
            'i' -> 'e'
            'e' -> 'i'
            'I' -> 'E'
            'E' -> 'I'
            else -> it
        }
    }.joinToString("")
}