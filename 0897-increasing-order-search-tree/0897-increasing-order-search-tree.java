class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = increasingBST(root.left);
        root.left = null;
        TreeNode right = increasingBST(root.right);
        
        if (left != null) {
            TreeNode temp = left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = root;
        }
        
        root.right = right;
        return (left != null) ? left : root;
    }
}

