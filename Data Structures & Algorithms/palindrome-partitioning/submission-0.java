class Solution {
    private String s;
    private List<List<String>> result = new ArrayList<>();
    private List<String> subset = new ArrayList<>();

    public List<List<String>> partition(String s) {
        this.s = s;

        backtrack(0, 0);

        return result;
    }

    private void backtrack(int left, int right) {
        if (right >= s.length()) {
            if (left == right) {
                result.add(new ArrayList<>(subset));
            }
            return;
        }

        if (isPalindrome(left, right)) {
            subset.add(s.substring(left, right + 1));
            backtrack(right + 1, right + 1);
            subset.removeLast();
        }

        backtrack(left, right + 1);

    }

    private boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }

        return true;
    }
}
