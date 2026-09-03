class KthLargest {
    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;

        for (var num: nums) {
            heap.add(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }
    }
    
    public int add(int val) {
        
        heap.add(val);

        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}
