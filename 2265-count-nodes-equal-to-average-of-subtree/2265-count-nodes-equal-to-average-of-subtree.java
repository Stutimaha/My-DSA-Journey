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

    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        solve(root, 0);
        return ans;
    }

    int ans = 0;

    private int[] solve(TreeNode root, int count) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int left[] = solve(root.left, count);
        int right[] = solve(root.right, count);
        int temp = root.val;
        root.val += (left[0] + right[0]);
        count = (left[1] + right[1]) + 1;
        if (temp == (root.val / count))  ans++; 
        return new int[] { root.val, count };
    }
}