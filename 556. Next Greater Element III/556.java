class Solution {
    public int nextGreaterElement(int n) {
        
        // Same as that of question 31. Next Permutation
        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        int idx = -1;

        for(int i = ch.length-2; i >= 0; i--) {
            if(ch[i] < ch[i+1]) {
                idx = i;
                break;
            }
        }

        if(idx == -1) return -1;
        else{
            for(int i = ch.length-1; i >= 0; i--) {
                if(ch[i] > ch[idx]) {
                    char temp = ch[i];
                    ch[i] = ch[idx];
                    ch[idx] = temp;
                    break; 
                }
            }
        }

        reverse(ch, idx+1, ch.length-1);

        // check if the number is becoming > than Integer.MAX_VALUE
        long res = 0;
        for(int i = 0; i < ch.length; i++) {
            if((Integer.MAX_VALUE-(ch[i]-'0')) < 10*res) return -1;
            res = (long)res*10 + (long)(ch[i]-'0');
        }
        return (int)res;

    }

    public void reverse(char[] ch, int l, int r) {
        
        while(l < r) {
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp; 
            l++; r--;
        }
        return;
    }
}
