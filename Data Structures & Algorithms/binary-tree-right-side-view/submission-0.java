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
    public List<Integer> rightSideView(TreeNode root) {
        final var levelMap = new HashMap<Integer, Integer>();

        traverse(root, 1, levelMap);

        final var result = new ArrayList<Integer>();
        var i = 1;
        while (levelMap.containsKey(i)) {
            result.add(levelMap.get(i));
            i += 1;
        }

        return result;
    }

    private void traverse(TreeNode node, int level, Map<Integer, Integer> result) {
        if (node == null) {
            return;
        }

        result.put(level, node.val);

        traverse(node.left, level + 1, result);
        traverse(node.right, level + 1, result);
    }
}
