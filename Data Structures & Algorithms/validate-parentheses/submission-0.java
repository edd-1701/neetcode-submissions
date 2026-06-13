class Solution {

    private final static List<Character> OPEN_BRACKETS = List.of('(', '{', '[');
    private final static List<Character> CLOSE_BRACKETS = List.of(')', '}', ']');

    private final static Map<Character, Character> BRACKET_MAP = Map.of(
        ')', '(', '}', '{', ']', '['
    );

    public boolean isValid(String s) {
        final var stack = new Stack<Character>();


        for (var i = 0 ; i < s.length(); i++) {
            final var currChar = s.charAt(i);

            if (OPEN_BRACKETS.contains(currChar)) {
                stack.push(currChar);
            } else if (CLOSE_BRACKETS.contains(currChar)) {
                if (stack.isEmpty() || stack.peek() != BRACKET_MAP.get(currChar)) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
