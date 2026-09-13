/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        var maxLevel = 0;
        var levelNodes = new ArrayList<TreeNode>();
        levelNodes.add(root);

        while (!levelNodes.isEmpty()) {
            maxLevel += 1;

            final var nextLevel = new ArrayList<TreeNode>();
            for (final var node : levelNodes) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }

                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }

            levelNodes = nextLevel;
        }

        return maxLevel;
    }
}
