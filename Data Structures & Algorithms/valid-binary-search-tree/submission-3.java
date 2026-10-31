/**

*/

class Solution {
    public boolean isValidBST(TreeNode root) {
        return traverse(root.left, Long.MIN_VALUE, root.val)
            && traverse(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean traverse(TreeNode node, long floor, long ceil) {
        if (node == null) {
            return true;
        }

        if (node.val <= floor || node.val >= ceil) {
            return false;
        }


        return traverse(node.left, floor, node.val) && traverse(node.right, node.val, ceil);
    }
}
