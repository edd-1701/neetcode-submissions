class Solution {
    private final static int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int ROWS;
    private int COLS;
    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        visited = new boolean[ROWS][COLS];

        var result = 0;
        for (var row = 0; row < ROWS; row++) {
            for (var col = 0; col < COLS; col++) {
                if (visited[row][col] || grid[row][col] == '0') {
                    continue;
                }

                result += 1;
                dfs(row, col, grid);
            }
        }

        return result;
    }

    private void dfs(int row, int col, char[][] grid) {
        final var queue = new ArrayDeque<int[]>();
        queue.offerLast(new int[] {row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            final var current = queue.pollFirst();

            for (var dir : DIRECTIONS) {
                final var newRow = current[0] + dir[0];
                final var newCol = current[1] + dir[1];

                if (newRow == ROWS || newRow < 0 || newCol == COLS || newCol < 0
                    || grid[newRow][newCol] == '0' || visited[newRow][newCol]) {
                    continue;
                }

                queue.offerLast(new int[] {newRow, newCol});
                visited[newRow][newCol] = true;
            }
        }
    }
}
