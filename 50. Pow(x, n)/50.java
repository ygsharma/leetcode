class Solution {
    public double myPow(double x, int n) {

        if(n == 0) return 1;
        long N = n;

        if(n < 0) {
            x = 1/x;
            N = -N;
        }

        if(N%2 == 0) return myPow(x*x, (int)(N/2));

        return x * myPow(x, (int)(N-1));
    }
}
