class Solution {
    private int[][] grid;
    private boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];


        var maxArea = 0;
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] != 1 || visited[row][col]) {
                    continue;
                }

                final var currArea = dfs(row, col);
                if (currArea > maxArea) {
                    maxArea = currArea;
                }
            }
        }

        return maxArea;
    }

    private int dfs(int row, int col) {
        if (row < 0 ||
                row == grid.length ||
                col < 0 ||
                col == grid[0].length ||
                visited[row][col] ||
                grid[row][col] == 0) {
            return 0;
        } 

        visited[row][col] = true;
        
        return grid[row][col] + dfs(row + 1, col) + dfs(row, col - 1) + dfs(row - 1, col) + dfs(row, col + 1);
    }
}
