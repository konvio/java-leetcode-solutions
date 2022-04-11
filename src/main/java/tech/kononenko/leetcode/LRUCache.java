package tech.kononenko.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 */
public class LRUCache {

    private int capacity;

    private Map<Integer, Node> cache;

    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity, 1);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     */
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);

        removeNode(node);
        addFirst(node);

        return node.value;
    }

    /**
     * Set or insert the value if the key is not already present. When the cache reached its capacity, it should
     * invalidate the least recently used item before inserting a new item.
     */
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            cache.remove(key);
        }

        if (cache.size() == capacity) removeLast();

        Node node = new Node(key, value);
        cache.put(key, node);
        addFirst(node);
    }

    private void addFirst(Node node) {
        Node first = head.next;

        head.next = node;

        node.prev = head;
        node.next = first;

        first.prev = node;
    }

    private void removeLast() {
        cache.remove(tail.prev.key);
        removeNode(tail.prev);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
