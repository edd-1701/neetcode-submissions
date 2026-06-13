class Solution {
    private boolean result = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null ) {
            return true;
        }

        traverse(root, Long.MIN_VALUE, Long.MAX_VALUE);

        return result;
    }


    private void traverse(TreeNode node, long min, long max) {
        if (!result || node == null) {
            return;
        }

        if (node.val <= min || node.val >= max) {
            result = false;
            return;
        }
    
        traverse(node.left, min, node.val);
        traverse(node.right, node.val, max);
    }


}
