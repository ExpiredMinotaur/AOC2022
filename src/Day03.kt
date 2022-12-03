fun main() {

    fun priority(input: Char): Int {
        return input.code - if (input.code < 97) 38 else 96
    }

    fun part1(input: List<String>): Int {
        return input.map { it.chunked(it.length / 2).map { s -> s.toSet() } }
            .map { it[0] intersect it[1] }
            .sumOf { it.sumOf { item -> priority(item) } }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3)
            .map { it[0].toSet() intersect it[1].toSet() intersect it[2].toSet() }
            .sumOf { priority(it.single()) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println("Part 1: " + part1(input))
    println("Part 2: " + part2(input))
}