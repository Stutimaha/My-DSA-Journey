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
    public TreeNode insertIntoBST(TreeNode head, int val) {
        if(head==null){
            head = new TreeNode();
            head.val = val;
            return head;
        }
        
        if(head.val<val){
            head.right = insertIntoBST(head.right, val);
        }
        else{
            head.left = insertIntoBST(head.left, val);
        }
        return head;
    }
}