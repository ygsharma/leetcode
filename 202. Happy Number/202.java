class Solution {
    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = getSum(n);
        }
        return n == 1; 
    }

    public int getSum(int n) {

        String s = String.valueOf(n);
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            int a = Character.getNumericValue(s.charAt(i));
            sum += a*a;
        }
        return sum;
    }

}
