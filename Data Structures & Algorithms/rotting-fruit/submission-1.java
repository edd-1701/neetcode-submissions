class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
        {0, -1},{-1, 0},{0, 1},{1, 0}
    };
    private final static int FRESH = 1;
    private final static int ROTTEN = 2;

    // record BadOrange(int row, int col, int minute){};
    public int orangesRotting(int[][] grid) {

        var freshRemaining = 0;
        var queue = new ArrayDeque<int[]>();
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == FRESH) {
                    freshRemaining += 1;
                }
                if (grid[row][col] == ROTTEN) {
                    queue.addLast(new int[]{row, col, 0});
                }
            }
        }

        var time = 0;
        while (!queue.isEmpty()) {
            final var orange = queue.pollFirst();

            for (var dir : DIRECTIONS) {
                final var newRow = orange[0] + dir[0];
                final var newCol = orange[1] + dir[1];

                if (!isValid(newRow, newCol, grid) || grid[newRow][newCol] != FRESH) {
                    continue;
                }
                grid[newRow][newCol] = ROTTEN;
                freshRemaining -= 1;
                queue.addLast(new int[]{newRow, newCol, orange[2] + 1});
            }

            time = orange[2];
        }

        return freshRemaining == 0 ? time : -1;

    }

    private static boolean isValid(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
