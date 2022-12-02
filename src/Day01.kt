fun main() {
    fun part1(input: List<String>): Int {
        val elves = input.chunkedByBlank() //separate elves
            .map { cal -> cal.sumOf { it.toInt() } } //count calories
        return elves.max() //return max amount of calories
    }

    fun part2(input: List<String>): Int {
        return input.chunkedByBlank()//separate elves
            .map { cal -> cal.sumOf { it.toInt() } } //count calories
            .sortedDescending() //sort elves by calories
            .take(3) //take top 3
            .sum() //sum top 3
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println("Part 1: " + part1(input))
    println("Part 2: " + part2(input))
}
