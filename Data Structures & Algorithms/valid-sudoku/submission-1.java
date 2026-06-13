class Solution {
    public boolean isValidSudoku(char[][] board) {
        final var rows = new ArrayList<Set<Character>>();
        final var cols = new ArrayList<Set<Character>>();
        final var squares = new ArrayList<Set<Character>>();

        for (var i = 0; i < 9; i++) {
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            squares.add(new HashSet<Character>());
        }

        for (var r = 0; r < 9; r++) {
            for (var c = 0; c < 9; c++) {
                final var currChar = board[r][c];
                if (currChar == '.') {
                    continue;
                }

                if (!rows.get(r).add(currChar)) {
                    return false;
                }

                if (!cols.get(c).add(currChar)) {
                    return false;
                }

                final var gridIndex = getGridIndex(r,c);
                if (!squares.get(gridIndex).add(currChar)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int getGridIndex(final int row, final int col) {
        if (row >= 0 && row <= 2) {
            return switch (col) {
                case 0,1,2 -> 0;
                case 3,4,5 -> 1;
                case 6,7,8 -> 2;
                default -> -1; 
            };
        } else if (row >= 3 && row <= 5) {
            return switch (col) {
                case 0,1,2 -> 3;
                case 3,4,5 -> 4;
                case 6,7,8 -> 5;
                default -> -1; 
            };
        } else {
            return switch (col) {
                case 0,1,2 -> 6;
                case 3,4,5 -> 7;
                case 6,7,8 -> 8;
                default -> -1; 
            };
        }
    }
}
