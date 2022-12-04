import java.lang.Integer.min

fun main() {

    fun part1(input: List<String>): Int {

        val ranges = input.map { it.split(',')
            .map { r -> r.split("-")}.map { r -> r[0].toInt()..r[1].toInt() }.map{r->r.toSet()} }

        var overlap = 0
        for(line in ranges)
        {
            val inter = line[0] intersect line[1]
            if(inter.size == min(line[0].size, line[1].size))
                overlap++
        }
        return overlap
    }

    fun part2(input: List<String>): Int {
        val ranges = input.map { it.split(',')
            .map { r -> r.split("-")}.map { r -> r[0].toInt()..r[1].toInt() }.map{r->r.toSet()} }

        var overlap = 0
        for(line in ranges)
        {
            val inter = line[0] intersect line[1]
            if(inter.isNotEmpty())
                overlap++
        }
        return overlap
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println("Part 1: " + part1(input))
    println("Part 2: " + part2(input))
}