class Solution {
    public boolean isValidSudoku(char[][] board) {
        final var rows = new ArrayList<Set<Character>>();
        final var cols = new ArrayList<Set<Character>>();
        final var grids = new ArrayList<Set<Character>>();

        for (var i = 0; i < 9; i++) {
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            grids.add(new HashSet<Character>());
        }

        for (var row = 0; row < 9; row++) {
            for (var i = 0; i < 9; i++) {
                if (board[row][i] != '.' && !rows.get(row).add(board[row][i])) {
                    return false;
                }
            }
        }

        for (var col = 0; col < 9; col++) {
            for (var i = 0; i < 9; i++) {
                if (board[i][col] != '.' && !cols.get(col).add(board[i][col])) {
                    return false;
                }
            }
        }

        for (var row = 0; row < 9; row++) {
            for (var col = 0; col < 9; col++) {
                final var currCell = board[row][col];
                final var gridIndex = (row / 3) * 3 + (col / 3);
                if (currCell != '.' && !grids.get(gridIndex).add(currCell)) {
                    return false;
                }
            }
        }

        return true;
    }
}
