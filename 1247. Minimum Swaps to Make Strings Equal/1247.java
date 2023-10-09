class Solution {
    public int minimumSwap(String s1, String s2) {
        
        int x = 0, y = 0;
        // count number of mismatch in string one of the strings
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(s1.charAt(i) == 'x') x+=1;
                else y+=1;
            }
        }

        // if total mismatch is odd return -1
        if((x+y) % 2 != 0) return -1;

        // if x+y even then two cases: both x,y odd or both even
        // if x,y even => each pair of xx yy take 1 swap = (x+y)/2
        // if x,y odd => x-1, y-1 even pair + remaining 1 pair of xy need 2 swap
        // (x-1+y-1)/2 + 2 = (x+y)/2 + 1
        return x%2 == 0 ? (x+y)/2 : (x+y)/2 + 1;
    }
}
