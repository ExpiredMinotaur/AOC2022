fun main() {

    val pattern = "\\\$ cd (.*)|(\\d+).*".toRegex()
    var fs = emptyMap<String, Int>().toMutableMap()

    fun loadFileSystem(input: List<String>){
        fs = emptyMap<String, Int>().toMutableMap()
        var dir = ""
        for(line in input)
        {
            val match = pattern.matchEntire(line)?: continue
            match.groups[1]?.value?.let {
                dir = when(it)
                {
                    "/" -> ""
                    ".." -> dir.substringBeforeLast("/","")
                    else -> if(it.isEmpty()) dir else "$dir/$it"
                }
            }?: match.groups[2]?.value?.toIntOrNull()?.let {
                var cd = dir
                while(true)
                {
                    fs[cd] = fs.getOrElse(cd){0}+it
                    if(cd.isEmpty()) break
                    cd= cd.substringBeforeLast("/","")
                }
            }
        }
    }

    fun part1(): Int {
        return fs.filter { (a,b)-> b <= 100000}.values.sum()
    }

    fun part2(): Int {
        val total = fs.getValue("")
        return fs.values.sorted().first { 70000000 - (total-it) >= 30000000 }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    loadFileSystem(testInput)
    check(part1() == 95437)
    check(part2() == 24933642)

    val input = readInput("Day07")
    loadFileSystem(input)
    println("Part 1: " + part1())
    println("Part 2: " + part2())
}