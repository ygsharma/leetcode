class Solution {
    public String minWindow(String s, String t) {

        if(t.length() > s.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int i = 0, j = 0;

        int count = t.length();
        int start_i = 0;
        int minWindowSize = Integer.MAX_VALUE;

        while(j < s.length()) {

            char rc = s.charAt(j);

            if(map.containsKey(rc)) {
                if(map.get(rc) > 0) count--;
                map.put(rc, map.get(rc)-1);
            }

            while(count == 0) {
                // shrink the window size
                int currWindowSize = j-i+1;

                if(minWindowSize > currWindowSize) {
                    minWindowSize = currWindowSize;
                    start_i = i;
                }

                char lc = s.charAt(i);
                if(map.containsKey(lc)) {
                    map.put(lc, map.get(lc)+1);
                    if(map.get(lc) > 0) count++;
                }
                i++;
            }
            j++;
        }
        
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i+minWindowSize);
    }

}
