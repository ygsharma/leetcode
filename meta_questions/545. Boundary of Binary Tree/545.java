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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        
        List<Integer> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root.left != null || root.right != null) list.add(root.val);

        if(root.left != null) leftBoundary(root.left, list);
        for(int i = 0; i < list.size(); i++) ans.add(list.get(i));
        list.clear();

        findLeaf(root, list);
        for(int i = 0; i < list.size(); i++) ans.add(list.get(i));
        list.clear();
        
        if(root.right != null) rightBoundary(root.right, list);
        for(int i = 0; i < list.size(); i++) ans.add(list.get(i));
    
        return ans;
    }

    public void findLeaf(TreeNode root, List<Integer> leaf) {
        if(root.left == null && root.right == null) {
            leaf.add(root.val);
            return;
        }
        if(root.left != null) findLeaf(root.left, leaf);
        if(root.right != null) findLeaf(root.right, leaf);
    }

    public void leftBoundary(TreeNode root, List<Integer> left) {
        if(root.left == null && root.right == null) return;

        left.add(root.val);
        if(root.left != null) leftBoundary(root.left, left);
        if(root.left == null && root.right != null) leftBoundary(root.right, left);
    }

    public void rightBoundary(TreeNode root, List<Integer> right) {
        if(root.left == null && root.right == null) return;

        if(root.right != null) rightBoundary(root.right, right);
        if(root.right == null && root.left != null) rightBoundary(root.left, right);
        right.add(root.val);
    }
}
