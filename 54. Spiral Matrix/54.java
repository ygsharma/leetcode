class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new ArrayList<>();

        int left = 0, right = matrix[0].length-1;
        int up = 0, down = matrix.length-1;

        while(ans.size() < matrix.length*matrix[0].length) {
            
            // Traverse right
            for(int col = left; col <= right; col++) {
                ans.add(matrix[up][col]);
            }

            // Traversing down
            for(int row = up+1; row <= down; row++) {
                ans.add(matrix[row][right]);
            }

            // Traversing left
            if(up != down) {
                for(int col = right-1; col >= left; col--){
                    ans.add(matrix[down][col]);
                }
            }

            // Traversing up
            if(left != right) {
                for(int row = down-1; row > up; row--) {
                    ans.add(matrix[row][left]);
                }
            }
            left++; right--;
            up++; down--;
            
        }
        return ans;
    }

    
}
