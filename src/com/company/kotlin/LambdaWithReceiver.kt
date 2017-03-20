package com.company.kotlin

class Layout<out T : Orientation>(val t: T) {

}

interface Orientation {
    fun rotate(): Orientation
}

class Vertical : Orientation {
    override fun rotate() = Horizontal()
    override fun toString(): String {
        return "Vertical"
    }
}

class Horizontal : Orientation {
    override fun rotate() = Vertical()
    override fun toString(): String {
        return "Horizontal"
    }
}

fun main(args: Array<String>) {
    val horizontal: Layout<Horizontal> = Layout<Horizontal>(Horizontal())
    val vertical: Layout<Vertical> = Layout<Vertical>(Vertical())


    val vert: Vertical = horizontal.rotate()
    val horz: Horizontal = vertical.rotate()
    println("Horizontal rotated is " + vert)
    println("Vertical rotated is " + horz)
}

fun Layout<Horizontal>.rotate(): Vertical = this.t.rotate()
fun Layout<Vertical>.rotate(): Horizontal = this.t.rotate()
