class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        next = null;
    }
}

class LinkedList {
    Node head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index >= size || head == null) {
            return -1;
        }

        var i = 0;
        var currNode = head;
        while (i < index) {
            currNode = currNode.next;
            i += 1;
        }

        return currNode.val;
    }

    public void insertHead(int val) {
        final var newNode = new Node(val);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size += 1;
    }

    public void insertTail(int val) {
        final var newNode = new Node(val);

        if (head == null) {
            head = newNode;
        } else {
            var lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }

        size += 1;
    }

    public boolean remove(int index) {
        if (index >= size || head == null) {
            return false;
        } else if (index == 0) {
            head = head.next;
            size -= 1;
            return true;
        }

        var i = 0;
        var currNode = head;
        while (i < index - 1) {
            currNode = currNode.next;

            i += 1;
        }

        if (currNode.next != null) {
            currNode.next = currNode.next.next;
        }

        size -= 1;

        return true;     
    }

    public ArrayList<Integer> getValues() {
        final var result = new ArrayList<Integer>();

        var currNode = head;
        while (currNode != null) {
            result.add(currNode.val);
            currNode = currNode.next;
        }
        return result;
    }
}
