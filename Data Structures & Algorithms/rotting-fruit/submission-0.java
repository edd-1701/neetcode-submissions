class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
        {0, -1},{-1, 0},{0, 1},{1, 0}
    };
    private final static int FRESH = 1;
    private final static int ROTTEN = 2;

    record BadOrange(int row, int col, int minute){};
    public int orangesRotting(int[][] grid) {

        var freshRemaining = 0;
        var queue = new ArrayDeque<BadOrange>();
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == FRESH) {
                    freshRemaining += 1;
                }
                if (grid[row][col] == ROTTEN) {
                    queue.addLast(new BadOrange(row, col, 0));
                }
            }
        }

        var time = 0;
        while (!queue.isEmpty()) {
            final var orange = queue.pollFirst();

            for (var dir : DIRECTIONS) {
                final var newRow = orange.row + dir[0];
                final var newCol = orange.col + dir[1];

                if (!isValid(newRow, newCol, grid) || grid[newRow][newCol] != FRESH) {
                    continue;
                }
                grid[newRow][newCol] = ROTTEN;
                freshRemaining -= 1;
                queue.addLast(new BadOrange(newRow, newCol, orange.minute + 1));
            }

            time = orange.minute;
        }

        return freshRemaining == 0 ? time : -1;

    }

    private static boolean isValid(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
