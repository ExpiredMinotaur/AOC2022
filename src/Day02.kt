fun main() {

    //1 = Rock 2 = Paper 3 = Scissors
    val opponentMap = mapOf("A" to 1, "B" to 2, "C" to 3) //Map opponent to value
    val playerMap = mapOf("X" to 1, "Y" to 2, "Z" to 3) //Map player to value
    val winMap = mapOf(1 to 3, 2 to 1, 3 to 2)  //win conditions
    val loseMap = mapOf(3 to 1, 1 to 2, 2 to 3) //lose conditions

    fun part1(input: List<String>): Int {
        var score = 0
        for (line in input) {
            val game = line.split(" ")
            val opponent = opponentMap[game[0]]
            val player = playerMap[game[1]]
            val win = winMap[player] == opponent
            val draw = player == opponent

            if (win) score += 6 //6 points for win
            else if (draw) score += 3 //3 points for win
            score += player!! //always score value of what the player played
        }

        return score
    }

    fun part2(input: List<String>): Int {
        var score = 0
        for (line in input) {
            val game = line.split(" ")
            val opponent = opponentMap[game[0]]
            when (game[1]) {
                "X" -> score += winMap[opponent]!! //lose
                "Y" -> score += opponent!! + 3 //draw
                "Z" -> score += loseMap[opponent]!! + 6 //win
            }
        }
        return score
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println("Part 1: " + part1(input))
    println("Part 2: " + part2(input))
}