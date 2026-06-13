
class Solution {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        final var left = getMaxPath(node.left);
        final var right = getMaxPath(node.right);

        final var currSum = node.val + left + right;
        if (currSum > result) {
            result = currSum;
        }

        dfs(node.left);
        dfs(node.right);
    }


    private int getMaxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        final var maxLeft = getMaxPath(node.left);
        final var maxRight = getMaxPath(node.right);
        final var result = node.val + Math.max(maxLeft, maxRight);
        return result < 0 ? 0 : result;
    }
}
