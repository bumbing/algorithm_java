public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int[][] result = new int[s.length()+1][t.length()+1];
        for(int i=1; i<=s.length(); i++)    result[i][0] = result[i-1][0]+1;
        for(int j=1; j<=t.length(); j++)    result[0][j] = result[0][j-1]+1;
        for(int i=1; i<s.length(); i++){
            for(int j=1; j<t.length(); j++){
                result[i][j] = result[i-1][j-1];
                if(s.charAt(i-1)!=t.charAt(j-1)){
                    result[i][j]++;
                }
                int tmp = 1 + Math.min(result[i][j-1], result[i-1][j]);
                result[i][j] = Math.min(result[i][j], tmp);
            }
        }
        return result[s.length()][t.length()] == 1;
    }
}