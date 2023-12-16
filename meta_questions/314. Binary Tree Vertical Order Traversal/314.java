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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        if(root == null) return new ArrayList();

        Map<Integer, List<Integer>> hm = new HashMap<>();
        // to store node and level data
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        // to reduce time complexity from Nlogn to N 
        int minLevel = 0, maxLevel = 0;
        
        while(!q.isEmpty()) {

            Pair<TreeNode, Integer> p = q.remove();
            TreeNode node = p.getKey();
            Integer level = p.getValue();

            if(!hm.containsKey(level)) hm.put(level, new ArrayList<>());
          
            hm.get(level).add(node.val);

            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);

            if(node.left != null) q.add(new Pair(node.left, level-1));
            if(node.right != null) q.add(new Pair(node.right, level+1));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = minLevel; i <= maxLevel; i++) {
            List<Integer> li = hm.get(i);
            ans.add(li);
        }

        return ans;
    }
}
