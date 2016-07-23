public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0) return s.length();
        int x=1, y=(s.charAt(0)-'0'>0)?1:0;
        for(int i=1; i<s.length(); i++){
            int temp = 0;
            if(Integer.parseInt(s.substring(i, i+1))>0)   temp += y;
            int num = Integer.parseInt(s.substring(i-1, i+1));
            if(num<=26 && num>=10)    temp += x;
            x = y;
            y = temp;
        }
        return y;
    }
}