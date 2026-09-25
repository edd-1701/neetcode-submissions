class Solution {
    public int lastStoneWeight(int[] stones) {
        final var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (var stone : stones) {
            heap.add(stone);
        }

        while (heap.size() > 1) {
            final var stone1 = heap.poll();
            final var stone2 = heap.poll();

            if (stone1 > stone2) {
                heap.add(stone1 - stone2);
            } else if (stone1 < stone2) {
                heap.add(stone2 - stone1);
            }
        }

        return heap.isEmpty() ? 0 : heap.poll();

    }
}
