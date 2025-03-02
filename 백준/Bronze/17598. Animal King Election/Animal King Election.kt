fun main() {

    var lion = 0;
    var tiger = 0;

    repeat(9) {
        if (readln().equals("Lion")) {
            lion++
        } else {
            tiger++
        }
    }

    print(
        if (lion > tiger) {
            "Lion"
        } else {
            "Tiger"
        }
    )
}