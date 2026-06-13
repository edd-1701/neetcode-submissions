class Solution {

    private final static List<int[]> DIRECTIONS = List.of(
        new int[]{0, -1}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{1, 0}
    );

    private final static Character LAND = '1';
    private final static Character WATER = '0';
    private final static Character VISITED = '-'; 

    public int numIslands(char[][] grid) {
        var islandCount = 0;

        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != LAND) {
                    continue;
                }

                islandCount += 1;
                dfs(i, j, grid);

            }
        }

        return islandCount;
    }

    private static void dfs(int row, int col, char[][] grid) {
        final var rowMax = grid.length - 1;
        final var colMax = grid[0].length - 1;

        final var queue = new LinkedList<int[]>();
        queue.add(new int[]{row,col});

        final var visited = new HashSet<String>();

        while (!queue.isEmpty()) {
            final var currCell = queue.pop();

            for (var dir : DIRECTIONS) {
                var newRow = currCell[0] + dir[0];
                var newCol = currCell[1] + dir[1];

                if (!(newRow >= 0 && newRow <= rowMax &&
                        newCol >= 0 && newCol <= colMax &&
                        grid[newRow][newCol] == LAND)) {
                            continue;
                }

                queue.add(new int[]{newRow, newCol});
                grid[newRow][newCol] = VISITED;
            }
        }

    
    }

}
