package com.kristinngodfrey.dsa



class LinkedList<T : Any> : Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set

    override fun isEmpty(): Boolean = size == 0

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty list"
        } else {
            return head.toString()
        }
    }
    fun push(value: T): LinkedList<T> = apply {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }
    fun append(value: T) {
        // 1
        if (isEmpty()) {
            push(value)
            return
        }
        // 2
        val newNode = Node(value = value)
        tail!!.next = newNode
        // 3
        tail = newNode
        size++
    }
    fun nodeAt(index: Int): Node<T>? {
        // 1
        var currentNode = head
        var currentIndex = 0
        // 2
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }
    fun insert(value: T, afterNode: Node<T>): Node<T> {
        // 1
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        // 2
        val newNode = Node(value = value, next = afterNode.next)
        // 3
        afterNode.next = newNode
        size++
        return newNode
    }
    fun pop(): T? {
        if (isEmpty()) return null
        val result = head?.value
        head = head?.next
        size--
        if (isEmpty()) {
            tail = null
        }
        return result
    }

    fun removeLast(): T? {
        // 1
        val head = head ?: return null
        // 2
        if (head.next == null) return pop()
        // 3
        size--
        // 4
        var prev = head
        var current = head
        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        // 5
        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value
        if (node.next == tail) {
            tail = node
        }
        if (node.next != null) {
            size--
        }
        node.next = node.next?.next
        return result
    }

    override fun iterator(): MutableIterator<T> =
        LinkedListIterator(this)

    override fun contains(element: T): Boolean {
        this.forEach {
            if (it == element) {
                return true
            }
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        elements.forEach { element ->
            if (!contains(element)) {
                return false
            }
        }
        return true
    }

    // Since the LinkedList doesn’t have a fixed size, add() and addAll() are always
    // successful and need to return true
    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        elements.forEach { append(it) }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()){
            if (iterator.next() == element) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    // The return value of removeAll is true if any elements were removed.
    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        elements.forEach {
            result = result || remove(it)
        }
        return result
    }

    // RetainAll removes any elements in the list besides the ones passed in as the parameter
    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            if (!elements.contains(iterator.next())) {
                iterator.remove()
                result = true
            }
        }
        return result
    }
}