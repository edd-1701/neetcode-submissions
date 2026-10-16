/*
    Iterate the matrix

    freshOranges = 0
    queue: store the locations of rotten in a queue
        Queue[int[]] [row, col, minute]

    minTime = 0

    process the queue (while not empty)
        for current rotten orange, do a BFS
            enqueue neighbor oranges for next minute

    if freshOranges == 0 return minTime otherwise, -1
*/

class Solution {
    private final static int FRESH = 1;
    private final static int ROTTEN = 2;
    private final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        final var queue = new ArrayDeque<int[]>();

        var freshOranges = 0;
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == FRESH) {
                    freshOranges += 1;
                } else if (grid[row][col] == ROTTEN) {
                    queue.addLast(new int[] {row, col, 0});
                }
            }
        }

        var time = 0;
        while (!queue.isEmpty()) {
            final var currOrange = queue.pollFirst();
            final var currTime = currOrange[2];

            for (var dir : DIRECTIONS) {
                final var newRow = currOrange[0] + dir[0];
                final var newCol = currOrange[1] + dir[1];

                if (newRow < 0 || newRow == grid.length || newCol < 0 || newCol == grid[0].length
                    || grid[newRow][newCol] != FRESH) {
                    continue;
                }

                grid[newRow][newCol] = ROTTEN;
                freshOranges -= 1;
                queue.addLast(new int[] {newRow, newCol, currTime + 1});
            }

            time = currTime;
        }

        return freshOranges == 0 ? time : -1;
    }
}
