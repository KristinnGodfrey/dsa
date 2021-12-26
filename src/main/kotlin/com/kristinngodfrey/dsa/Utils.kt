package com.kristinngodfrey.dsa

import kotlin.math.ceil

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}

val stringBuilder = StringBuilder()

fun <T : Any> LinkedList<T>.printInReverse(): String {
    this.nodeAt(0)
        ?.printInReverseHelper()
    return stringBuilder.toString()
}
fun <T : Any> Node<T>.printInReverseHelper() {
    this.next
        ?.printInReverseHelper()
    // 1
    if (this.next != null) {
        stringBuilder.append(" <- ")
    }
    // 2
    stringBuilder.append(this.value.toString())
}

var counter = 0

// find the length of the list
fun <T : Any> LinkedList<T>.printMiddleNode(): String {
    println(this.size)
    this.nodeAt(0)?.printMiddleNodeHelper()
    val middleNode = counter / 2
    return this.nodeAt(middleNode)?.value.toString()
}

// increment counter
fun <T : Any> Node<T>.printMiddleNodeHelper() {
    this.next?.printMiddleNodeHelper().let { counter++ }
}