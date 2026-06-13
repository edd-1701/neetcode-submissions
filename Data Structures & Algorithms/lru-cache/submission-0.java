public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private Map<Integer, Node> data;
    private int capacity;
    private Node head;
    private Node tail;


    public LRUCache(int capacity) {
        data = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        final var lastTrueNode = tail.prev;
        lastTrueNode.next = node;
        node.prev = lastTrueNode;
        node.next = tail;
        tail.prev = node;
    }
    
    public int get(int key) {
        final var node = data.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (data.containsKey(key)) {
            remove(data.get(key));
        }

        final var newNode = new Node(key, value);
        data.put(key, newNode);
        insert(newNode);


        if (data.size() > capacity) {
            final var lru = head.next;
            remove(head.next);
            data.remove(lru.key);
        }
    }
}
