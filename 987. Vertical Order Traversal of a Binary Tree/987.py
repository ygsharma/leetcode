# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:

        result = dict()
        q = [(0, 0, root)]

        while len(q) > 0 :

            hd, lvl, node = q.pop(0)

            if(node.left):
                q.append((hd-1, lvl+1, node.left))
            if(node.right):
                q.append((hd+1, lvl+1, node.right))

            if hd not in result:
                result[hd] = {}

            if lvl not in result[hd]:
                result[hd][lvl] = []

            result[hd][lvl].append(node.val)
            
        ans = []
        rows = sorted(result.keys())

        for row in rows:
            cols = sorted(result[row].keys())
            temp = []
            for col in cols:
                temp += sorted(result[row][col])
            ans.append(temp)
        return ans

            
            
        
