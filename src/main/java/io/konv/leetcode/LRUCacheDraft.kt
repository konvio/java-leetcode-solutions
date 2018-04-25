package io.konv.leetcode

/**
 * 146. LRU Cache
 */
class LRUCacheDraft(private val capacity: Int) {

    private val cache = HashMap<Int, Node>(capacity)

    private val head = Node(-1)

    private val tail = Node(-1)

    init {
        head.next = tail
        tail.previous = head
    }

    /**
     * Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     */
    fun get(key: Int): Int {
        val node = cache[key] ?: return -1
        invalidate(node)
        return node.value
    }

    /**
     * Set or insert the value if the key is not already present. When the cache reached its capacity, it should
     * invalidate the least recently used item before inserting a new item.
     */
    fun put(key: Int, value: Int) {
        cache.remove(key)?.unlink()
        if (cache.size == capacity) removeLast()
        val node = Node(value)
        cache[key] = node
        head.insertNext(node)
    }

    private fun removeLast() {
        if (head.next == tail) return
        cache.remove(tail.previous?.value)?.unlink()
    }

    private fun invalidate(node: Node) {
        node.unlink()
        head.insertNext(node)
    }

    private data class Node(val value: Int) {

        var previous: Node? = null

        var next: Node? = null

        fun insertNext(node: Node) {
            val oldNext = next

            next = node
            node.previous = this

            node.next = oldNext
            oldNext?.previous = node
        }

        fun unlink() {
            previous?.next = next
            next?.previous = previous
        }
    }
}