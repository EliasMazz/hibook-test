fun main(args: Array<String>) {
    hibookTest("5", 1)
    hibookTest("1", 3)
}

private val mapOfNumPadToNeighbors = mapOf(
    "0" to listOf("8"),
    "1" to listOf("2", "4"),
    "2" to listOf("1", "3", "5"),
    "3" to listOf("2", "6"),
    "4" to listOf("1", "5", "7"),
    "5" to listOf("2", "4", "6", "8"),
    "6" to listOf("3", "5", "9"),
    "7" to listOf("4", "8"),
    "8" to listOf("5", "7", "0", "9"),
    "9" to listOf("6", "8")
)

private var listOfPossibleNumbers: MutableList<String> = mutableListOf()

private fun hibookTest(number: String, n: Int) {
    if (number.toInt() !in 0..mapOfNumPadToNeighbors.count()) return
    graphOfNeighborNumbers(number, n)
    print(listOfPossibleNumbers.toString()+"\n")
    listOfPossibleNumbers = mutableListOf()
}

private fun graphOfNeighborNumbers(number: String, n: Int): String {
    val resultNumber = number
    fun verifyNumber(number: String): String {
        if (resultNumber.last().toString() == number) {
            mapOfNumPadToNeighbors[number.last().toString()]?.forEach { neighborNumber ->
                graphOfNeighborNumbers(resultNumber + neighborNumber, n)
            }
            return resultNumber
        }
        return ""
    }
    if (resultNumber.count() == n) {
        listOfPossibleNumbers.add(resultNumber)
        return resultNumber
    }
    for (numPadKeys in 0..mapOfNumPadToNeighbors.keys.count()) {
        verifyNumber(numPadKeys.toString())
    }
    return number
}

