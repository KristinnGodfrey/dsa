package com.kristinngodfrey.dsa

fun main() {
    "printing doubles" example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        println(list)
        for (item in list) {
            println("Double: ${item * 2}")
        }
    }
}