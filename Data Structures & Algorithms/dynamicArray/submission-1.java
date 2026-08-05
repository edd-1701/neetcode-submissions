class DynamicArray {
    int[] data;
    int len;
    int capacity;

    public DynamicArray(int capacity) {
        data = new int[capacity];
        len = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        return data[i];
    }

    public void set(int i, int n) {
        data[i] = n;
    }

    public void pushback(int n) {
        if (len == capacity) {
            resize();
        }

        data[len++] = n;
    }

    public int popback() {
        // var originalLen = len;
        // len -= 1;
        return data[--len];
    }

    private void resize() {
        final var resized = new int[capacity * 2];
        for (var i = 0; i < len; i++) {
            resized[i] = data[i];
        }

        capacity = capacity * 2;
        data = resized;
    }

    public int getSize() {
        return len;
    }

    public int getCapacity() {
        return capacity;
    }
}
