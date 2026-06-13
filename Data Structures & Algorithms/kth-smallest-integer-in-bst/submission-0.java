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
    private int k;
    private PriorityQueue<Integer> heap;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        heap = new PriorityQueue<>(Comparator.reverseOrder());

        traverse(root);

        return heap.poll();        
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        heap.add(node.val);
        if (heap.size() > k) {
            heap.poll();
        }

        traverse(node.left);
        traverse(node.right);
    }
}
