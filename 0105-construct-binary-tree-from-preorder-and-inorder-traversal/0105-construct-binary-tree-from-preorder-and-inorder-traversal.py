# class TreeNode(object):
#     def __init__(self, val = 0, left = None, right = None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def buildTree(self, preorder, inorder):
        inorder_index_map = {value: idx for idx, value in enumerate(inorder)}
        
        self.preorder_index = 0
        
        def array_to_tree(left, right):
            if left>right: # No nodes remaining
                return None 
            
            root_val = preorder[self.preorder_index]
            self.preorder_index += 1
            
            root = TreeNode(root_val)
            
            root_index = inorder_index_map[root_val]
            root.left = array_to_tree(left, root_index-1)
            root.right = array_to_tree(root_index+1,right)
            
            return root
        return array_to_tree(0, len(inorder)-1)