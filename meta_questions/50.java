class Solution {
    public double myPow(double x, int n) {
        
        return solve(x, (long) n);
    }


    public double solve(double x, long n) {
        if(n == 0) return 1;

        if(n < 0) {
            n = -1 * n;
            x = 1/x;
        }
        
        if(n%2 == 0) return solve(x*x, n/2);
        else {
            return x * solve(x, n-1);
        }
    }

}
