record Entry(int row, int col, int elev) {}
;
class Solution {
    private static int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int swimInWater(int[][] grid) {
        /*
            Create a priority queue
            structure of elem: (row, col, time)
        */
        final var LEN = grid.length;
        final var visited = new boolean[LEN][LEN];

        final var queue = new PriorityQueue<Entry>((a, b) -> a.elev - b.elev);
        queue.add(new Entry(0, 0, grid[0][0]));
        visited[0][0] = true;

        var result = 0;
        while (!queue.isEmpty()) {
            final var cell = queue.poll();

            result = Math.max(result, cell.elev);

            // if result is end, return
            if (cell.row == LEN - 1 && cell.col == LEN - 1) {
                return result;
            }

            for (var dir : DIRECTIONS) {
                final var newRow = cell.row + dir[0];
                final var newCol = cell.col + dir[1];

                if (newRow < 0 || newRow == LEN || newCol < 0 || newCol == LEN
                    || visited[newRow][newCol]) {
                    continue;
                }

                queue.add(new Entry(newRow, newCol, grid[newRow][newCol]));
                visited[newRow][newCol] = true;
            }

            // iterate 4 directions, place valid ones in the heap
        }

        return result;
    }
}
