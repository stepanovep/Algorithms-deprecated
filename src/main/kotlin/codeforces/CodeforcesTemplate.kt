package codeforces

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.util.*


fun solve() {
    //your solution

}


fun hasNext() : Boolean {
    while (!st.hasMoreTokens()) {
        st = StringTokenizer(input.readLine() ?: return false)
    }
    return true
}

fun next() = if (hasNext()) st.nextToken()!! else throw RuntimeException("No tokens")

fun nextInt() = next().toInt()

fun nextLong() = next().toLong()

fun nextDouble() = next().toDouble()

fun nextLine() = if (hasNext()) st.nextToken("\n")!! else throw RuntimeException("No tokens")

fun nextArray(n : Int) = IntArray(n, { nextInt() })

val ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null

var input = when(ONLINE_JUDGE) {
    true -> BufferedReader(InputStreamReader(System.`in`), 32768)
    else -> BufferedReader(FileReader("in.txt"))
}

var output = when(ONLINE_JUDGE) {
    true -> PrintWriter(BufferedWriter(OutputStreamWriter(System.out)))
    else -> PrintWriter(BufferedWriter(FileWriter("out.txt")))
}

var st = StringTokenizer("")

fun main(args: Array<String>) {
    val start = System.currentTimeMillis()
    solve()

    output.close()
    input.close()

    if (!ONLINE_JUDGE) {
        System.err.println("${System.currentTimeMillis() - start} ms")
    }
}