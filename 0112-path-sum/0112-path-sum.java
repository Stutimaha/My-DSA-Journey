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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }
    
    private boolean helper(TreeNode node, int targetSum, int currentSum) {
        if (node == null) {
            return false;
        }
        
        currentSum += node.val;
        
        if (node.left == null && node.right == null) {
            return currentSum == targetSum;
        }
        
        boolean leftPath = helper(node.left, targetSum, currentSum);
        boolean rightPath = helper(node.right, targetSum, currentSum);
        
        return leftPath || rightPath;
    }
}
