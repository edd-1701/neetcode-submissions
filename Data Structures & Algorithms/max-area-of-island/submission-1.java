class Solution {
    private final static int[][] DIRECTIONS = {{1, 0, -1, 0, 0, 1, 0, -1}};
    private int ROWS;
    private int COLS;
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        visited = new boolean[ROWS][COLS];

        var maxArea = 0;
        for (var row = 0; row < ROWS; row++) {
            for (var col = 0; col < COLS; col++) {
                if (grid[row][col] == 0 || visited[row][col]) {
                    continue;
                }

                maxArea = Math.max(maxArea, getArea(row, col, grid));
            }
        }

        return maxArea;
    }

    private int getArea(int r, int c, int[][] grid) {
        if (r < 0 || r == ROWS || c < 0 || c == COLS || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }
        visited[r][c] = true;

        return 1 + getArea(r + 1, c, grid) + getArea(r - 1, c, grid) + getArea(r, c + 1, grid)
            + getArea(r, c - 1, grid);
    }
}
