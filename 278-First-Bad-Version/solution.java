/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int head = 1, tail = n;
        while(head<tail+1){
            int mid = (head+tail)/2;
            if(isBadVersion(mid))   head = mid;
            else    tail = mid-1;
        }
        if(isBadVersion(tail))  return tail;
        else return head;
    }
}