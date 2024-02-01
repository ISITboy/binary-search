import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val arr = listOf(1, 5, 3, 5, 0, 3, 6, 8, 1, 13, 5, 2)
    val n = 6
    findPair(arr, n)
}

fun findPair(arr: List<Int>, n: Int) {
    val map = mutableMapOf<Int, Int>()
    arr.forEach { number ->
        val difference = n - number
        when (map[difference]) {
            null -> map[number] = number
            else -> println(Pair(number, map.remove(difference)))
        }
    }
}