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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length-1;
        return construct(nums, 0, n);
    }
    
    public TreeNode construct(int[] nums, int leftIndex, int rightIndex){
        if(leftIndex > rightIndex){
            return null;
        }
        
        int maxIndex = leftIndex;
        for(int i = leftIndex+1; i<=rightIndex;i++){
            if(nums[i]>nums[maxIndex]){
                maxIndex = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[maxIndex]);
        
        root.left = construct(nums, leftIndex, maxIndex-1);
        root.right = construct(nums, maxIndex+1, rightIndex);
        return root;
    }
}