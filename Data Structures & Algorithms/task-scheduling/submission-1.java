class Solution {
    public int leastInterval(char[] tasks, int n) {
        final var taskFrequency = new HashMap<Character, Integer>();
        for (var task : tasks) {
            taskFrequency.merge(task, 1, Integer::sum);
        }

        final var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (var freq : taskFrequency.values()) {
            maxHeap.add(freq);
        }

        final var queue = new LinkedList<int[]>();

        var time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {

            if (!queue.isEmpty() && queue.peekFirst()[1] == time) {
                maxHeap.add(queue.removeFirst()[0]);
            }

            if (!maxHeap.isEmpty()) {
                final var remainingRuns = maxHeap.poll() - 1;
                if (remainingRuns > 0){
                    queue.add(new int[]{remainingRuns, time + n + 1});
                }
            }

            time += 1;
        }


        return time;
    }
}
