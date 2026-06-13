class Solution {
    private List<String> result;
    private int n;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        this.n = n;

        helper(0, 0, new StringBuilder());
        return result;
    }

    private void helper(int open, int close, StringBuilder str) {
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



// 0 -> 0
// 1 -> 1 ()
// 2 -> 2 ()(), (()),
// 3 -> 5 ((())), ()()(), (())(), ()(()), (()())
// 4 -> (((()))), ((()))(), (())()(), ()()()(), ()((())),()()(()), (())(()), ()(())()


//consistent pattern is nested parens (()), and sequence ()()
//At n = 1, I can only build one parens
//At n = 2, I can do 2 nested, or 2 regular


