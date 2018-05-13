package algebra

fun gcd(a: Int, b: Int) : Int {
    return if (b == 0) a else gcd(b, a % b)
}

fun lcd(a: Int, b: Int): Int {
    return a / gcd(a, b) * b
}

fun main(args : Array<String>) {
    println(gcd(21, 41))
    println(lcd(3, 7))
}