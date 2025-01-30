fun main() {

    val map = mapOf(
        "CU" to "see you",
        ":-)" to "I’m happy",
        ":-(" to "I’m unhappy",
        ";-)" to "wink",
        ":-P" to "stick out my tongue",
        "(~.~)"	to "sleepy",
        "TA" to "totally awesome",
        "CCC" to "Canadian Computing Competition",
        "CUZ" to "because",
        "TY" to "thank-you",
        "YW" to "you’re welcome",
        "TTYL" to "talk to you later"
    )

    val ans = StringBuilder()

    while (true) {
        val input = readln()
        if (map.containsKey(input)) {
            ans.append(map[input])
        } else {
            ans.append(input)
        }
        ans.append('\n')
        if (input.equals("TTYL")) {
            break
        }
    }

    print(ans)

}