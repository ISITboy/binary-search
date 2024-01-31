import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val arr = listOf(1, 5, 3, 5, 0, 3, 6, 8, 13, 5, 2)
    val n = 1
    println(findPair(arr, n))
}

fun findPair(arr: List<Int>, n: Int): Pair<Int, Int> {
    val map = hashMapOf<Int, Int>()
    for (number in arr) {
        val difference = n - number
        if (containsNumber(map, difference)) return Pair(number, map[n - number]!!)
        map[number] = number
    }
    return Pair(-1, -1)
}

private fun containsNumber(map: HashMap<Int, Int>, difference: Int) = map.containsValue(difference)

