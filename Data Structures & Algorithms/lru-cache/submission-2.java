class LRUCache {
    private LinkedHashMap<Integer, Integer> data;
    private int capacity;

    public LRUCache(int capacity) {
        data = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!data.containsKey(key)) {
            return -1;
        }

        final var val = data.remove(key);
        data.putLast(key, val);
        return data.get(key);
    }
    
    public void put(int key, int value) {
        if (data.containsKey(key)) {
            data.remove(key, value);
        }
        
         
            data.putLast(key, value);
        

        if (data.size() > capacity) {
            data.pollFirstEntry();
        }


    }
}
