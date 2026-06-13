class KthLargest {

    private PriorityQueue<Integer> data;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        data = new PriorityQueue<>();

        for (var num : nums) {
            data.add(num);
            if (data.size() > k) {
                data.poll();
            }
        }
    }
    
    public int add(int val) {
        data.add(val);
        if (data.size() > k) {
            data.poll();
        }
        return data.peek();
    }
}
