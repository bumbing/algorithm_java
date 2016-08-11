public class Solution {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        int head =0, tail=c.length-1;
        while(head<tail){
            char tmp = c[head];
            c[head] = c[tail];
            c[tail] = tmp;
            head++;
            tail--;
        }
        return new String.valueOf(c);
    }
}