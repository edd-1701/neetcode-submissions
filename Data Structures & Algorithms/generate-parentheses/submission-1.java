/**
    Backtracking question

    recursive question:
    Make a recursive function which keeps track of used open and closed parens
        helper(int open, int close, Str currString)

            if open is matched with close and number of pairs is `n`:
                valid result, add to result
                return function

            if there are open parens remaining (open < n):
                add open parens to str
                call recursive helper(open + 1, close, str)

            if there are less close parens than open:
                add close parens to str
                call recursive helper(open, close + 1, str)
*/

class Solution {
    private List<String> result = new ArrayList<>();
    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        helper(0, 0, new StringBuilder());
        return result;        
    }

    private void helper(final int open, final int close, final StringBuilder str) {
        if (open == close && close == n) {
            result.add(str.toString());
            return;
        }

        if (open < n) {
            str.append("(");
            helper(open + 1, close, str);
            str.deleteCharAt(str.length() - 1);
        }


        if (close < open) {
            str.append(")");
            helper(open, close + 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }


}
