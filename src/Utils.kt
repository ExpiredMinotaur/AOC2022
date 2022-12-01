import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt")
    .readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

fun List<String>.chunkedByBlank(): List<List<String>> =
        fold(mutableListOf(mutableListOf<String>())) { acc, item ->
            if ((item.isBlank()))
                acc.add(mutableListOf())
            else
                acc.last().add(item)
            acc
        }