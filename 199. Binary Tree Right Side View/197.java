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
    
    public List<Integer> rightSideView(TreeNode root) {

        List<int[]> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {

            int size = q.size();
            int[] temp = new int[size];

            
            for(int i = 0; i < size; i++) {
                TreeNode node = q.remove();

                temp[i] = node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ans.add(temp);
        }

        for(int[] arr : ans) {
            result.add(arr[arr.length-1]);
        }
        return result;
    }

}
