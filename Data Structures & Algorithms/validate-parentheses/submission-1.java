class Solution {
    private final static Set<Character> OPEN_CHARS = Set.of('(', '[', '{');

    private final static Map<Character, Character> MAP_CHARS = Map.of(')', '(', ']', '[', '}', '{');
    public boolean isValid(String s) {
        final var stack = new Stack<Character>();

        for (var i = 0; i < s.length(); i++) {
            final var currChar = s.charAt(i);

            if (OPEN_CHARS.contains(currChar)) {
                stack.push(currChar);
                continue;
            }

            final var expectedChar = MAP_CHARS.get(currChar);
            if (stack.isEmpty() || stack.peek() != expectedChar) {
                return false;
            }

            stack.pop();
        }

        return stack.isEmpty();
    }
}
