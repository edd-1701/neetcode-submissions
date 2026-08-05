class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class Deque {
    Node head;
    Node tail;
    int size;

    public Deque() {
        head = new Node(-1);
        tail = new Node(-1);
        size = 0;

        head.next = tail;
        tail.prev = head;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void append(int value) {
        final var newNode = new Node(value);
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        newNode.next = tail;
        tail.prev = newNode;

        size += 1;
    }

    public void appendleft(int value) {
        final var newNode = new Node(value);
        newNode.prev = head;
        newNode.next = head.next;

        head.next.prev = newNode;
        head.next = newNode;

        size += 1;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }

        final var node = tail.prev;
        node.prev.next = node.next;
        node.next.prev = node.prev;

        size -= 1;

        return node.val;
    }

    public int popleft() {
        if (size == 0) {
            return -1;
        }

        final var node = head.next;
        node.prev.next = node.next;
        node.next.prev = node.prev;

        size -= 1;

        return node.val;
    }
}
