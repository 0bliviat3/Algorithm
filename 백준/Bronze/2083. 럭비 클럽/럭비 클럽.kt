fun main() {
    var info: String
    val ans = StringBuilder()

    while (true) {
        info = readln()
        if (info == "# 0 0") {
            break
        }
        ans.append(sortClub(info))
    }

    print(ans)
}

fun sortClub(info: String): String {
    val arr = info.split(" ")
    if (arr[1].toInt() > 17 || arr[2].toInt() >= 80) {
        return "${arr[0]} Senior\n"
    }
    return "${arr[0]} Junior\n"
}