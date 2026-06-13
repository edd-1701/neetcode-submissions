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
    private Map<Integer, List<Integer>> levelMap = new HashMap<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        traverse(root, 1);

        final var result = new ArrayList<List<Integer>>();
        var i = 1;
        while (levelMap.containsKey(i)) {
            result.add(levelMap.get(i));
            i += 1;
        }

        return result;

    }

    private void traverse(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (!levelMap.containsKey(level)) {
            levelMap.put(level, new ArrayList<Integer>());
        }
        levelMap.get(level).add(node.val);

        traverse(node.left, level + 1);
        traverse(node.right, level + 1);


    }
}
