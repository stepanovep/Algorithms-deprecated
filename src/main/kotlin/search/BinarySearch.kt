package search

private fun binarySearch(a: IntArray, value: Int, function: (arg: Int) -> Int): Boolean {
    var left  = 0
    var right = a.size

    while (left < right) {
        val middle = (left + right) / 2
        val f = function.invoke(value)

        when {
            f == a[middle] -> return true
            f < a[middle]  -> right = middle
            f > a[middle]  -> left = middle + 1
        }
    }

    return false
}

fun main(args: Array<String>) {

    print(binarySearch(intArrayOf(1, 2, 4, 10), 2, { i -> i*i }))

}