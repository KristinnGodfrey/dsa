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

fun <T : Any> LinkedList<T>.printMiddleNode(): String {
    return this.nodeAt(size/2)?.value.toString()
}