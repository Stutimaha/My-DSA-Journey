# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return "[]"
        
        # Use a queue for level-order traversal
        queue = [root]
        result = []
        
        while queue:
            node = queue.pop(0)
            
            if node:
                result.append(str(node.val))
                queue.append(node.left)
                queue.append(node.right)
            else:
                result.append("null")
        
        # Join result list as a string
        return "[" + ",".join(result) + "]"

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data == "[]":
            return None
        
        # Split the data string into values
        values = data[1:-1].split(",")
        root = TreeNode(int(values[0]))
        queue = [root]
        i = 1
        
        while queue:
            node = queue.pop(0)
            
            if values[i] != "null":
                left_node = TreeNode(int(values[i]))
                node.left = left_node
                queue.append(left_node)
            i += 1
            
            if values[i] != "null":
                right_node = TreeNode(int(values[i]))
                node.right = right_node
                queue.append(right_node)
            i += 1
        
        return root
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))