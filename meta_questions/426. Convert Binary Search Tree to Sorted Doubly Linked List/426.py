"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

class Solution:
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        def helper(node):
            nonlocal first, last
            if node:
                helper(node.left)

                if last:
                    # link the previous node (last)
                    # with the current one (node)
                    last.right = node
                    node.left = last
                else:
                    # keep the smallest node
                    # to close DLL later on
                    first = node
                last = node

                helper(node.right)
        
        if not root:
            return None

        # the smallest (first) and the largest (last) nodes
        first, last = None, None

        helper(root)
        # close DLL
        first.left = last
        last.right = first

        return first

        
