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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return ans;
        dfs(root, 0);
        Collections.reverse(ans);
        return ans;
    }

    public void dfs(TreeNode root, int level) {
        // for every new level make a  list
        if(ans.size() == level) ans.add(new ArrayList());

        // add root value to list 
        ans.get(level).add(root.val);

        if(root.left != null) dfs(root.left, level+1);
        if(root.right != null) dfs(root.right, level+1);
    }
}

