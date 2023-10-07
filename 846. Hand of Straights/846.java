class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i : hand) {
            if(!tm.containsKey(i)) {
                tm.put(i, 1);
            }else{
                tm.put(i, tm.get(i)+1);
            }  
        }

        while(tm.size() > 0) {
            int minCard = tm.firstKey();
            for(int i = minCard; i < minCard + groupSize; i++) {
                if(!tm.containsKey(i)) return false;
                else{
                    int count = tm.get(i);
                    if(count == 1) tm.remove(i);
                    else tm.replace(i, tm.get(i)-1);
                }
            }
        }
        return true;
    }
}
