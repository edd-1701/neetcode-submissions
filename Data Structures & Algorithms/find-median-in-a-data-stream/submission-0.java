class MedianFinder {

    private PriorityQueue<Integer> smallHalf;
    private PriorityQueue<Integer> largeHalf;

    public MedianFinder() {
        smallHalf = new PriorityQueue<Integer>((a,b) -> b - a);
        largeHalf = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        smallHalf.add(num);
        rebalanceHeaps();
    }

    private void rebalanceHeaps() {

        if (!largeHalf.isEmpty() && smallHalf.peek() > largeHalf.peek()) {
            largeHalf.add(smallHalf.poll());
        }

        if (Math.abs(smallHalf.size() - largeHalf.size()) <= 1) {
            return;
        }
        
        if (smallHalf.size() > largeHalf.size()) {
            largeHalf.add(smallHalf.poll());
        } else {
            smallHalf.add(largeHalf.poll());
        }

    }
    
    public double findMedian() {
        if (smallHalf.size() == largeHalf.size()) {
            return (double)(smallHalf.peek() + largeHalf.peek()) / 2;
        } else if (smallHalf.size() > largeHalf.size()) {
            return (double)smallHalf.peek();
        } else {
            return (double)largeHalf.peek();
        }
    }
}
