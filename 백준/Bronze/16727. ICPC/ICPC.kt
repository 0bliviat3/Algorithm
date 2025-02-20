fun main() {
    val arr1 = readln()
        .split(" ")
        .map { it.toInt() }

    val arr2 = readln()
        .split(" ")
        .map { it.toInt() }

    val p = arr1[0] + arr2[1]
    val s = arr1[1] + arr2[0]

    print(
        when {
            p > s -> "Persepolis"
            s > p -> "Esteghlal"
            arr2[1] > arr1[1] -> "Persepolis"
            arr2[1] < arr1[1] -> "Esteghlal"
            else -> "Penalty"
        }
    )
}