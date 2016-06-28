public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while(true)
        {
            set.add(n);
            n = nextNumber(n);
            if(n == 1)
            {
                break;
            }
            if(set.contains(n))
            {
                return false;
            }
        }
                
       return true;
    }
    
    private int nextNumber(int n){
        int result = 0;
        while(n != 0)
        {
            result += (n%10) * (n%10);
            n /= 10;
        }
        return result;
    }
}