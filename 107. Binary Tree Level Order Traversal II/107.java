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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
       
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> subAns = new ArrayList<>(); 
            while(n-- > 0) {
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                subAns.add(q.remove().val);
            }
            ans.add(subAns);
        }
        for (int i = 0, j = ans.size() - 1; i < j; i++) {
            ans.add(i, ans.remove(j));
        }
        return ans;
    }
}
