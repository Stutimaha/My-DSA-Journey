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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return root;
        }
        TreeNode answer = root;
        if(root.val>val){//go left
            answer = searchBST(root.left, val);
        }
        if(root.val<val){//go right
            answer = searchBST(root.right, val);
        }
        return answer;
    }
}