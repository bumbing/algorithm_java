public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0 || citations==null)  return 0;
        int l = citations.length;
        int head = 0, tail = l-1;
        while(head<tail-1){
            int mid = head + (tail-head)/2;
            if(citations[mid]>=l-mid) head = mid;
            else    tail = mid;
        }
        if(citations[tail]>=l-tail)    return l-tail;
        else return l-tail-1;
    }
}