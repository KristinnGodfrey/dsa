package com.kristinngodfrey.dsa

fun main() {
    val list = LinkedList<Int>()
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.add(5)
    list.printInReverse()
    println(list)
    println(list.printMiddleNode())
}
