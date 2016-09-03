public class Solution {
    public int strStr(String haystack, String needle) {
        int[] index = new int[26];
        for(int i=0; i<index.length; i++)   index[i]=-1;
        for(int i=0; i<needle.length(); i++)    index[needle.charAt(i)-'a'] = i;
        
        int skip;
        int m = haystack.length(), n = needle.length();
        for(int i=0; i<=m-n; i+= skip){
            skip = 0;
            for(int j=n-1; j>=0; j--){
                if(needle.charAt(j)!=haystack.charAt(i+j)){
                    skip = Math.max(1, j-index[haystack.charAt(i+j)]);
                    break;
                }
            }
            if(skip == 0)   return i;
        }
        return -1;
    }
}
