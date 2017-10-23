package com.gradoid.example

import com.gradoid.example.Shape.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import java.math.BigDecimal
import kotlin.system.measureTimeMillis

// 1. hello world; IDE shortcuts
fun main(args: Array<String>) {
    println("Hello, Kotlin!")
}

// 2. data class vs POJO
data class User(val name: String, val age: Int)

// 3. single expression functions
fun add(a: Int, b: Int): Int {
    return a + b
}

// 4. when
fun whenFun(n: Int) = when (n) {
    1 -> "one"
    in 2..5 -> "few"
    else -> "error"
}

fun whenFun2(n: Int) = when {
    n == 1 -> "one"
    n in 2..5 -> "few"
    n < 0 -> "negative"
    else -> "error"
}

// 5. null
fun getText() = if (System.currentTimeMillis() % 10 >= 5L) "this is the text" else null

fun nullTest() {
    val text = getText()

    // error
//    println(text.length)
    println(text?.length)
    println(text?.length ?: 0)

    text?.let { "$it is not null" }
}

// 6. extension functions; standard lib extension functions
fun String.hello() {
    println("Hello, $this")

    // let, apply, takeIf...
}

// 7. Int - extend; infix function
infix fun Int.dividableBy(number: Int) = this % number == 0

fun testDividableBy() {
    val dividable = 5.dividableBy(3)

    val dividableWithInfix = 5 dividableBy 3

    val map = hashMapOf<Int, String>(5 to "five")
}

// 8. extension properties
val Int.bd get() = BigDecimal(this)

fun testBD() {
    val bigDecimal = 5.bd
}

// 9. higher order functions
fun Int.transform(f: (Int) -> Int) = f(this) + 1

fun testHigherOrderFunctions() {
    val number = 6

    val transformed = number.transform { it * 2 }
    println(transformed)
}

// 10. build-in collection extension functions
fun collectionsTest() {
//    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numbers = listOf(1..10).flatten()

    val result = numbers.map { it * 2 }
//    val result = numbers.filter { it dividableBy 2 }
    // show more library functions

    println(result)
}

// 11. enums, when - autocomplete
enum class Shape { CIRCLE, TRIANGLE, RECTANGLE }

// demonstrate autocomplete for parameters
// compile error when adding new value for Shape
fun getAngleCount(shape: Shape) = when (shape) {
    CIRCLE -> Int.MAX_VALUE
    TRIANGLE -> 3
    RECTANGLE -> 4
}

// 12. smart cast
fun smartCastTest() {
    val value = getText()
    if (value != null) println(value.reversed())
}

// 13. coroutines
fun runCoroutines() {
    async(CommonPool) {
        val duration = measureTimeMillis { coroutines() }
        println("duration: ${duration}ms")
    }
    Thread.sleep(5_000)
}

suspend fun coroutines() {
    val coroutines = List(100_000) {
        async(CommonPool) {
            delay(1000L)
            1
        }
    }

    println(coroutines.sumBy { it.await() })
}
