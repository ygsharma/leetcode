class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        Map<String, List<String>> hm = new HashMap<>();

        for(String s : strings) {
            
            StringBuilder pattern = new StringBuilder();
            for(int i = 1; i < s.length(); i++) {
                char prev = s.charAt(i-1);
                int val1 = prev - 'a' +1;
                int val2 = s.charAt(i) - 'a' + 1;
                int val = val2 > val1 ? val2 - val1 : 26 - val1 + val2;
                pattern.append(val).append(","); 
            }
            String pat = pattern.toString();
            List<String> list = hm.containsKey(pat) ? hm.get(pat) : new ArrayList();
            list.add(s);
            hm.put(pat, list);   
        }
        return new ArrayList(hm.values());
    }
}
