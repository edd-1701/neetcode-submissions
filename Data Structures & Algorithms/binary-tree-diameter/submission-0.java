class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return diameter;
        }

        helper(root, 0);

        return diameter;
    }

    private int helper(final TreeNode node, int jumps) {
        if (node == null) {
            return 0;
        }

        final var left = helper(node.left, jumps);
        final var right = helper(node.right, jumps);

        jumps = Math.max(jumps, left + right);
        if (jumps > diameter) {
            diameter = jumps;
        }

        // System.out.println(node.val + " Jumps: " + jumps);
        return 1 + (Math.max(left, right));
    } 
}
