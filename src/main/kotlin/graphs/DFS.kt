package graphs

import java.util.*
import kotlin.collections.ArrayList

private lateinit var cc: IntArray                       // номер компоненты связности для каждой вершины
private lateinit var visited: BooleanArray              // помечаем посещенные вершины (можно 0-1, можно раскраской)
private lateinit var graph: Array<ArrayList<Int>>       // граф, заданный списком смежности

private var currentComponent = 0


private fun dfs() {
    val n = graph.size
    for (v in 0 until n) {
        if (!visited[v]) {
            explore(v)
            currentComponent++
        }
    }
}

private fun explore(v: Int) {
    visited[v] = true
    cc[v] = currentComponent
    for (to in graph[v]) {
        if (!visited[to])
            explore(to)
    }
}

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val n = nextInt()
    cc = IntArray(n)
    visited = BooleanArray(n)
    graph = Array(n, { ArrayList<Int>() })

    val m = nextInt()
    for (i in 0 until m) {
        val from = nextInt() - 1
        val to = nextInt() - 1
        graph[from].add(to)
        graph[to].add(from)         // для неориентированного графа
    }

    dfs()

    println("Граф: ${graph.toList()}")
    println("Компоненты связности: ${cc.toList()}")
}