public class Solution {
    public String longestPalindrome(String s) {
        int[] l = new int[s.length()*2 + 3];
        char[] t = new char[s.length()*2 + 3];
        t[0] = '$';
        t[s.length()*2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2*i + 1] = '#';
            t[2*i + 2] = s.charAt(i);
        }
        t[s.length()*2 + 1] = '#';
        int[] p = new int[t.length];
        
        int result = 0;
        int center = 0, right = 0;
        for (int i = 1; i < t.length-1; i++) {
            int mirror = 2*center - i;

            if (right > i)
                p[i] = Math.min(right - i, p[mirror]);
 
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
                p[i]++;
 
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            if(p[i]>p[result])  result = i;
        }
        
        return s.substring((result - 1 - p[result])/2, (result + 1 + p[result])/2);

    }
}


