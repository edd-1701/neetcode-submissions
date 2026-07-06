class Solution {
    private int result = 0;
    private int[][] matrix;
    private int ROWS;
    private int COLS;    
    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        ROWS = matrix.length;
        COLS = matrix[0].length;
        memo = new int[ROWS][COLS];

        for (var row = 0; row < ROWS; row++) {
            for (var col = 0; col < COLS; col++) {
                if (memo[row][col] > 0) {
                    continue;
                }
                var steps = dfs(row, col, -1);
                result = Math.max(result, steps);
            }
        }

        return result;
    }

    private int dfs(int r, int c, int lastVal) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS) {
            return 0;
        } else if (matrix[r][c] <= lastVal) {
            return 0;
        } else if (memo[r][c] > 0) {
            return memo[r][c];
        }
        
        final var down = dfs(r + 1, c, matrix[r][c]);
        final var up = dfs(r - 1, c, matrix[r][c]);
        final var right = dfs(r, c + 1, matrix[r][c]);
        final var left = dfs(r, c - 1, matrix[r][c]);

        final var result = 1 + Collections.max(List.of(down,up,right,left));

        memo[r][c] = result;
        return result;

    }
}
