import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val array = generatedArray(range = 1000).sorted()
    println(array)
    val a = 38391641
    val executionTime = measureTimeMillis{
        println(findNumber(array, a))
    }
    println("resulted Time: $executionTime milliseconds")
}

private fun generatedArray(range:Int) = IntArray(range){ Random.nextInt(Int.MAX_VALUE)}

private fun findNumber(array: List<Int>, a: Int): Int {
    var currentArray = array.toList()       // определяем рабочий массив, чтобы не изменить исходный
    val centerNumber = CenterNumber()       // инстанция класса CenterNumber для удобного хранения данных

    return if (a < currentArray.first()) -1                 // условия для частных случаев,
    else if (a > currentArray.last()) currentArray.last()   // которые можем проверить сразу, что экономит
    else if (array.contains(a)) a                           // время решения (если имеем частный случай)
    else {
        while (currentArray.size != 1) {
            centerNumber.index = getCenterNumberIndex(currentArray.size)
            centerNumber.value = currentArray[centerNumber.index]

            currentArray = getCorrectRange(
                flag = a > centerNumber.value,
                index = centerNumber.index,
                array = currentArray
            )
        }
        currentArray.first()
    }
}

private fun getCenterNumberIndex(size: Int) = size / 2

private fun getCorrectRange(flag: Boolean, index: Int, array: List<Int>): List<Int> {
    return when (flag) {
        false -> getLeftSideList(index, array)
        true -> getRightSideList(index, array)
    }
}

private fun getRightSideList(index: Int, array: List<Int>) = array.takeLast(array.size - index)
private fun getLeftSideList(index: Int, array: List<Int>) = array.take(index)


data class CenterNumber(
    var value:Int =0,
    var index:Int=0
)