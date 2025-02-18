fun main() {

    print(
        (1..5)
            .map { readln().toInt() }
            .fold(mutableSetOf<Int>()) { set, num ->
                if (!set.add(num)) set.remove(num)
                set
            }.first()
    )
}