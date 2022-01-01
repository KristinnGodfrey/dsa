package com.kristinngodfrey.dsa
import org.junit.Test

class TestLinkedList {
    private val testLinkedList = LinkedList<Int>()
    private val testMutableLinkedList: MutableCollection<Int> = LinkedList()
    init {
        testLinkedList.append(1); testLinkedList.append(2); testLinkedList.append(3)
        testMutableLinkedList.add(5); testMutableLinkedList.add(2); testMutableLinkedList.add(1)
    }

    @Test
    fun createAndLinkNodes(){
        val node1 = Node(value = 1)
        val node2 = Node(value = 2)
        val node3 = Node(value = 3)
        node1.next = node2
        node2.next = node3
        assert(node1 == Node(value = 1, next = Node(value = 2, next = Node(value = 3))))
    }

    @Test
    fun pushNodes() {
        val list = LinkedList<Int>()
        list.push(3).push(2).push(1)
        assert(list.toString() == "1 -> 2 -> 3")
    }

    @Test
    fun appendNodes() {
        val list = LinkedList<Int>()
        list.append(1)
        list.append(2)
        list.append(3)
        assert(list.toString() == "1 -> 2 -> 3")
    }

    @Test
    fun insertNodesAt() {
        assert(testLinkedList.toString() == "1 -> 2 -> 3") // before
        var middleNode = testLinkedList.nodeAt(1)!!
        for (i in 1..3) {
            middleNode = testLinkedList.insert(-1 * i, middleNode)
        }
        assert(testLinkedList.toString() == "1 -> 2 -> -1 -> -2 -> -3 -> 3") // after
    }

    @Test
    fun popNode() {
        assert(testLinkedList.toString() == "1 -> 2 -> 3") // before
        val poppedValue = testLinkedList.pop()
        assert(testLinkedList.toString() == "2 -> 3") // after
        assert(poppedValue == 1) // popped value
    }

    @Test
    fun removeLastNode() {
        assert(testLinkedList.toString() == "1 -> 2 -> 3") // before
        val removedValue = testLinkedList.removeLast()
        assert(testLinkedList.toString() == "1 -> 2") // after
        assert(removedValue == 3) // popped value
    }

    @Test
    fun removeNodeAfter() {
        assert(testLinkedList.toString() == "1 -> 2 -> 3") // before
        val removedValue = testLinkedList.removeAfter(testLinkedList.nodeAt(0)!!)
        assert(testLinkedList.toString() == "1 -> 3") // after
        assert(removedValue == 2) // removed value
    }

    @Test
    fun iterableLinkedList() {
        for (item in testLinkedList) {
            continue // I just need to test iterating over the list
        }
    }

    @Test
    fun linkedListContains() {
        assert(testLinkedList.toString() == "1 -> 2 -> 3") // before
        assert(testLinkedList.contains(1))
        assert(testLinkedList.contains(2))
        assert(testLinkedList.contains(3))
        assert(!testLinkedList.contains(4))
    }

    @Test
    fun linkedListContainsAll() {
        assert(testLinkedList.toString() == "1 -> 2 -> 3") // before
        val list2 = LinkedList<Int>()
        list2.push(1)
        list2.push(2)
        list2.push(3)
        assert(testLinkedList.containsAll(list2))
        list2.push(4)
        assert(!testLinkedList.containsAll(list2))
    }

    @Test
    fun removeElements() {
        assert(testMutableLinkedList.toString() == "5 -> 2 -> 1") // before
        testMutableLinkedList.remove(2)
        assert(testMutableLinkedList.toString() == "5 -> 1")
        testMutableLinkedList.remove(1)
        assert(testMutableLinkedList.toString() == "5")
    }

    @Test
    fun retainElements() {
        assert(testMutableLinkedList.toString() == "5 -> 2 -> 1") // before
        testMutableLinkedList.add(3)
        testMutableLinkedList.add(4)
        testMutableLinkedList.retainAll(listOf(3, 4, 5))
        assert(testMutableLinkedList.toString() == "5 -> 3 -> 4")
    }

    @Test
    // print the list reversed
    fun testChallenge1() {
        assert(testLinkedList.toString() == "1 -> 2 -> 3") // before
        assert(testLinkedList.printInReverse() == "3 <- 2 <- 1")
    }

    @Test
    // print the middle node of the list
    fun testChallenge2() {
        assert(testLinkedList.toString() == "1 -> 2 -> 3") // before
        assert(testLinkedList.printMiddleNode() == "2")
        testLinkedList.append(4)
        assert(testLinkedList.printMiddleNode() == "3")
    }


}