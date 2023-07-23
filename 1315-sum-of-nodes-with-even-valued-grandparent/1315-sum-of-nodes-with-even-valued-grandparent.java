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
    public int sumEvenGrandparent(TreeNode root) {
        return evenGP(root, null, null);
    }
    
    public int evenGP(TreeNode current, TreeNode parent, TreeNode grandParent){
        if(current==null){
            return 0;
        }
        
        int sum = 0;
        
        if (grandParent != null && grandParent.val % 2 == 0) {
            sum += current.val;
        }
        
        sum += evenGP(current.left, current, parent);
        sum += evenGP(current.right, current, parent);
        
        return sum;
    }
}