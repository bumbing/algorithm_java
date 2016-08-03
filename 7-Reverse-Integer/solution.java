public class Solution {
    public int reverse(int x) {
        boolean positive = x>0;
        x = Math.abs(x);
        int y = 0;
        while(x!=0){
            if(Integer.MAX_VALUE/y<10)   return 0;
            int temp = x%10;
            x /= 10;
            y = y * 10 + temp;
        }
        if(!positive){
            if(y+Integer.MAX_VALUE>0)   return 0;
            y = y * -1;
        }
        return y;
    }
}