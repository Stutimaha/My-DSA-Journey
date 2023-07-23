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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int idx = 0;
        
        while(idx<traversal.length()){
            int level = 0;
            while(traversal.charAt(idx) == '-'){
                level++;
                idx++;
            }
            
            int val = 0;
            while (idx < traversal.length() && Character.isDigit(traversal.charAt(idx))){
                val = val * 10 + (traversal.charAt(idx)-'0');
                idx++;
            }
            
            TreeNode node = new TreeNode(val);
            
            if(level == stack.size()){
                if(!stack.isEmpty()){
                    stack.peek().left = node;
                }
            }
            else{
                while(level != stack.size()){
                    stack.pop();
                }
                stack.peek().right = node;
            }
            stack.push(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek(); //this will be the root node
    }
}