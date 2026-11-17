class Solution {
    private final static List<int[]> DIRECTIONS =
        List.of(new int[] {0, -1}, new int[] {-1, 0}, new int[] {0, 1}, new int[] {1, 0});
    private final static int WATER = -1;
    private final static int LAND = Integer.MAX_VALUE;
    private final static int TREASURE = 0;
    private int[][] grid;

    public void islandsAndTreasure(int[][] grid) {
        final var chests = new ArrayDeque<int[]>();

        for (var r = 0; r < grid.length; r++) {
            for (var c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == TREASURE) {
                    chests.addLast(new int[] {r, c, 0});
                }
            }
        }

        bfs(chests, grid);
    }

    private void bfs(ArrayDeque<int[]> chests, int[][] grid) {
        while (!chests.isEmpty()) {
            final var currCell = chests.pollFirst();
            final var row = currCell[0];
            final var col = currCell[1];
            final var steps = currCell[2];

            // if (steps < grid[row][col]) {
            //     grid[row][col] = steps;
            // }

            for (var dir : DIRECTIONS) {
                final var newRow = row + dir[0];
                final var newCol = col + dir[1];

                if (isValidCell(newRow, newCol, grid) && grid[newRow][newCol] == LAND) {
                    
                    chests.addLast(new int[] {newRow, newCol, steps + 1});
                    grid[newRow][newCol] = steps + 1;
                }
            }
        }
    }

    private boolean isValidCell(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
            && grid[row][col] != WATER;
    }
}
