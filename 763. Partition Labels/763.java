class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> hm = new HashMap<>();


        for(int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), i);
        }

        // take left index and right index
        int li = -1, ri = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // if ri of next character in string is greater then update ri 
            ri = Math.max(ri, hm.get(ch));
            
            // if i == ri add to list this is our solution and make left index = right index
            if(i == ri) {
                ans.add(ri-li);
                li = ri;
            }
            
        }
        return ans;
    }
}
