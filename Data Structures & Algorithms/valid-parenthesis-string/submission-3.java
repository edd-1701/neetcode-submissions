class Solution {
    public boolean checkValidString(String s) {
        final var open = new Stack<Integer>();
        final var wildcard = new Stack<Integer>();
        for (var i = 0; i < s.length(); i++) {
            final var currChar = s.charAt(i);

            if (currChar == '(') {
                open.add(i);
            } else if (currChar == '*') {
                wildcard.add(i);
            } else if (!open.isEmpty()) {
                open.pop();
            } else if (!wildcard.isEmpty()) {
                wildcard.pop();
            } else {
                return false;
            }
        }

        while (!open.isEmpty() && !wildcard.isEmpty()) {
            if (wildcard.pop() < open.pop()) {
                return false;
            }
        }

        return open.isEmpty();
    }
}
