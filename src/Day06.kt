fun main() {

    fun part1(input: String): Int {
        val sections = input.windowed(4,1)
        for(i in 1..sections.size)
        {
            if(sections[i].toSet().size  == 4)
                return i+4
        }
        return 0
    }

    fun part2(input: String): Int {
        val sections = input.windowed(14,1)
        for(i in 1..sections.size)
        {
            if(sections[i].toSet().size  == 14)
                return i+14
        }
        return 0
    }

    // test if implementation meets criteria from the description, like:
    check(part1("mjqjpqmgbljsphdztnvjfqwrcgsmlb") == 7)
    check(part2("mjqjpqmgbljsphdztnvjfqwrcgsmlb") == 19)

    val input = readInput("Day06")
    println("Part 1: " + part1(input[0]))
    println("Part 2: " + part2(input[0]))
}