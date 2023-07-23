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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateMaxPathSum(root);
        return maxSum;
    }

    private int calculateMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(calculateMaxPathSum(root.left), 0);
        int right = Math.max(calculateMaxPathSum(root.right), 0);
        int currentSum = root.val + left + right;
        maxSum = Math.max(maxSum, currentSum);

        return root.val + Math.max(left, right);
    }
}



