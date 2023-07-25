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
    public boolean isValidBST(TreeNode root) {
       return validBST(root, null, null);
    }
    
    public boolean validBST(TreeNode root, Integer min, Integer max) {
       if (root == null) {
            return true;
        }
        
        int val = root.val;

        if ((min != null && val <= min) || (max != null && val >= max)) {
            return false;
        }
        
        return validBST(root.left, min, val) && validBST(root.right, val, max);
    }
}