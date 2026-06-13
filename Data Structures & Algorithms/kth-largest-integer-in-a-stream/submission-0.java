class KthLargest {

    private PriorityQueue<Integer> data;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        data = new PriorityQueue<>(Collections.reverseOrder());

        for (var num : nums) {
            data.add(num);
        }
    }
    
    public int add(int val) {
        data.add(val);

        final var tmpContainer = new ArrayList<Integer>();

        for (var i = 1; i <= k; i++) {
            tmpContainer.add(data.poll());
        }

        final var result = tmpContainer.getLast();

        while (!tmpContainer.isEmpty()) {
            data.add(tmpContainer.removeFirst());
        }

        return result;
    }
}
