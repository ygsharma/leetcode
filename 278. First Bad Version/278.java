/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        // apply binary search algorithm to find first bad
        int l = 1, r = n;

        while(l <= r) {
            int mid = l + (r-l)/2;

            if(!isBadVersion(mid)) l = mid+1;
            else r = mid-1;
        }
        return l;
    }
}
