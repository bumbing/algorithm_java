public class Solution {
    public boolean isUgly(int num) {
        int[] divide = {2, 3, 5};
        for(int i: divide)
            while(num%i==0) num/=i;
            
        return num==1;
    }
}