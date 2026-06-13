class Solution {
    public int lastStoneWeight(int[] stones) {

        final var heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (var stone : stones) {
            heap.add(stone);
        }

        while (heap.size() >= 2) {
            final var stoneX = heap.poll();
            final var stoneY = heap.poll();

            if (stoneX.equals(stoneY)) {
                continue;
            }

            heap.add(stoneX < stoneY ? stoneY - stoneX : stoneX - stoneY);
        }


        return heap.isEmpty() ? 0 : heap.poll();
    }
}
