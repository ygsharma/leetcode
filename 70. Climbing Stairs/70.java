class Solution {
    public int climbStairs(int n) {

        return helperFunc(n, new int[n+1]);
    }


    // Solution using memoization
    public int helperFunc(int n, int[] qb){
        if(n == 1 || n == 2){
            return n;
        }
        
        if(qb[n] > 0) return qb[n];

        int nm1 = helperFunc(n-1, qb);
        int nm2 = helperFunc(n-2, qb);

        qb[n] = nm1 + nm2;

        return nm1 + nm2;
    }
}
