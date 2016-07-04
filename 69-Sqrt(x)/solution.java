public class Solution {
    public int mySqrt(int x) {
        long head = 0, tail = 1<<16, mid;
        while(head * head != x && tail * tail != x && head <= tail){
            mid = (head + tail)/ 2;    
            if(mid * mid == x)   return (int)mid;
            else if(mid * mid > x)   tail = mid -1;
            else head = mid+1;
        }
        
        return (head * head == x)?(int)head:(int)tail;

    }
}