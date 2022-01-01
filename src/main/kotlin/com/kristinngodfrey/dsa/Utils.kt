package com.kristinngodfrey.dsa


infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}

// Linked Lists challenge 1
val stringBuilder = StringBuilder()

fun <T : Any> LinkedList<T>.printInReverse(): String {
    this.nodeAt(0)?.printInReverseHelper()
    return stringBuilder.toString()
}
fun <T : Any> Node<T>.printInReverseHelper() {
    this.next?.printInReverseHelper()

    if (this.next != null) {
        stringBuilder.append(" <- ")
    }

    stringBuilder.append(this.value.toString())
}

// Linked Lists challenge 2
fun <T : Any> LinkedList<T>.printMiddleNode(): String =
    this.nodeAt(size/2)?.value.toString()

