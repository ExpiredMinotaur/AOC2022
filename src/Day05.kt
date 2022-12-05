fun main() {

    var crateDataOriginal: List<List<Char>>  =emptyList()
    var moveData: List<List<Int>> = emptyList()

    fun loadData(input: List<String>){
        val data = input.chunkedByBlank()
        //Parse Crate Data
        val lineLength = data[0].maxOf { it.length }
        crateDataOriginal = data[0].dropLast(1)
            .map{it.padEnd(lineLength, ' ')
                .slice(1 until lineLength step 4)
                .toList()
            }
            .transpose()
            .map { it.filter { char -> !char.isWhitespace() } }

        //Parse Move Data
        val regex = "move (\\d+) from (\\d+) to (\\d+)".toRegex()
        moveData = data[1].map{regex.find(it)!!.groupValues.drop(1).map{v-> v.toInt()}}
    }

    fun part1(): String {
        var crateData = crateDataOriginal.map { it.toMutableList() }.toMutableList() //copy list
        for((amount, from, to) in moveData)
        {
            val moving = crateData[from-1].takeLast(amount).reversed()
            crateData[to-1].addAll(moving)
            crateData[from-1] = crateData[from-1].dropLast(amount).toMutableList()
        }
        return crateData.map{it.last()}.joinToString ("")
    }

    fun part2(): String {
        var crateData = crateDataOriginal.map { it.toMutableList() }.toMutableList() //copy list
        for((amount, from, to) in moveData)
        {
            val moving = crateData[from-1].takeLast(amount)
            crateData[to-1].addAll(moving)
            crateData[from-1] = crateData[from-1].dropLast(amount).toMutableList()
        }
        return crateData.map{it.last()}.joinToString ("")
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    loadData(testInput)
    check(part1() == "CMZ")
    check(part2() == "MCD")

    val input = readInput("Day05")
    loadData(input)
    println("Part 1: " + part1())
    println("Part 2: " + part2())
}