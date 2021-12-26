package com.kristinngodfrey.dsa
import org.junit.Test

class TestLinkedList {
    @Test
    fun testCreatingAndLinkingNodes(){
        val node1 = Node(value = 1)
        val node2 = Node(value = 2)
        val node3 = Node(value = 3)
        node1.next = node2
        node2.next = node3
        assert(node1 == Node(value = 1, next = Node(value = 2, next = Node(value = 3))))
    }

    @Test
    fun testPushNodes() {
        val list = LinkedList<Int>()
        list.push(3).push(2).push(1)
        assert(list.toString() == "1 -> 2 -> 3")
    }

    @Test
    fun testAppendNodes() {
        val list = LinkedList<Int>()
        list.append(1)
        list.append(2)
        list.append(3)
        assert(list.toString() == "1 -> 2 -> 3")
    }

    @Test
    fun testInsertNodesAt() {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        assert(list.toString() == "1 -> 2 -> 3") // before
        var middleNode = list.nodeAt(1)!!
        for (i in 1..3) {
            middleNode = list.insert(-1 * i, middleNode)
        }
        assert(list.toString() == "1 -> 2 -> -1 -> -2 -> -3 -> 3") // after
    }

    @Test
    fun testPopNode() {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        assert(list.toString() == "1 -> 2 -> 3") // before
        val poppedValue = list.pop()
        assert(list.toString() == "2 -> 3") // after
        assert(poppedValue == 1) // popped value
    }

    @Test
    fun testRemoveLastNode() {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        assert(list.toString() == "1 -> 2 -> 3") // before
        val removedValue = list.removeLast()
        assert(list.toString() == "1 -> 2") // after
        assert(removedValue == 3) // popped value
    }

    @Test
    fun testRemoveNodeAfter() {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        assert(list.toString() == "1 -> 2 -> 3") // before
        val removedValue = list.removeAfter(list.nodeAt(0)!!)
        assert(list.toString() == "1 -> 3") // after
        assert(removedValue == 2) // removed value
    }

    @Test
    fun testIterableLinkedList() {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        for (item in list) {
            continue // I just need to test iterating over the list
        }
    }

    @Test
    fun testLinkedListContains() {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        assert(list.contains(1))
        assert(list.contains(2))
        assert(list.contains(3))
        assert(!list.contains(4))
    }

    @Test
    fun testLinkedListContainsAll() {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        val list2 = LinkedList<Int>()
        list2.push(1)
        list2.push(2)
        list2.push(3)
        assert(list.containsAll(list2))
        list2.push(4)
        assert(!list.containsAll(list2))
    }
}