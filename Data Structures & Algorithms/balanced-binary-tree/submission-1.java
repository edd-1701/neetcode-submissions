class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        final var lHeight = getTreeHeight(root.left);
        final var rHeight = getTreeHeight(root.right);

        if (Math.abs(lHeight - rHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getTreeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        var lHeight = getTreeHeight(node.left);
        var rHeight = getTreeHeight(node.right);

        return 1 + Math.max(lHeight, rHeight);
    }
}
