class Solution {
    public boolean canPermutePalindrome(String s) {
        
        Map<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
        }

        int count = 0;
        for (Character ch : hm.keySet()) {
            if(hm.get(ch) % 2 != 0) count++; 
        }

        if(s.length() % 2 == 0) return count == 0;
        else return count == 1;
    }
}
