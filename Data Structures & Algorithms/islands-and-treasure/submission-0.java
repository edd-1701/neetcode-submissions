class Solution {
    private final static List<int[]> DIRECTIONS = List.of(
        new int[]{0, -1}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{1, 0}
    );
    private final static int WATER = -1;
    private final static int LAND = Integer.MAX_VALUE;
    private final static int TREASURE = 0;
    private int[][] grid;

    public void islandsAndTreasure(int[][] grid) {
        this.grid = grid;

        final var bfsSource = new ArrayList<int[]>();
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == TREASURE) {
                    bfsSource.add(new int[]{row, col, 0});
                }
            }
        }

        bfs(bfsSource);
    }

    private void bfs(ArrayList<int[]> sources) {
        final var visited = new boolean[grid.length][grid[0].length];
        for (var treasure : sources) {
            visited[treasure[0]][treasure[1]] = true;
        }

        while (!sources.isEmpty()) {
            final var currSource = sources.removeFirst();
            final var row = currSource[0];
            final var col = currSource[1];
            final var steps = currSource[2];

            if (steps < grid[row][col]) {
                //todo: enqueueing can be skipped if cell has less steps aready
                grid[row][col] = steps;
            }

            for (var dir : DIRECTIONS) {
                final var newRow = row + dir[0];
                final var newCol = col + dir[1];

                if (isTraversable(newRow, newCol) && !visited[newRow][newCol]) {
                    sources.add(new int[]{newRow, newCol, steps + 1});
                    visited[newRow][newCol] = true;
                }
            }

            // visited[row][col] = false;

        }

    }

    private boolean isTraversable(int row, int col) {
        return row >= 0 &&
            row < grid.length &&
            col >= 0 &&
            col < grid[0].length &&
            grid[row][col] != WATER;
    }
}
