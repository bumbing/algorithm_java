public class Solution {
    public boolean isMatch(String s, String p) {
        if(s.length() == 0 || p.length() == 0){
            if(s.length() == p.length())    return true;
            else if(s.length() == 0){
                for(int i=0; i<p.length(); i++)  if(p.charAt(i)!='*')   return false;
                return true;
            }else {
                for(int i=0; i<s.length(); i++)  if(s.charAt(i)!='*')   return false;
                return true;
            }
        }
        
        char[] ca1 = s.toCharArray();
        char[] ca2 = p.toCharArray();
        
        boolean[][] result = new boolean[ca1.length][ca2.length];
        for(int i=0; i<ca1.length; i++){
            for(int j=0; j<ca2.length; j++){
                boolean temp = compare(ca1[i], ca2[j]);
                if(i==0 && j==0){
                    result[i][j] = temp;
                }else if(i==0){
                    result[i][j] = ((result[i][j-1] & ca2[j-1]='*') | result[i][j-1]) & temp;
                }else if(j==0){
                    result[i][j] = ((result[i-1][j] & ca1[i-1]='*') | result[i-1][j]) & temp;
                }else{
                    result[i][j] = temp&(result[i-1][j-1] | (result[i-1][j] & ca1[i-1]='*') | (result[i][j-1] & ca2[j-1]='*'));
                }
            }
        }
        return result[ca1.length-1][ca2.length-1];
    }
    
    private boolean compare(char a, char b){
        if(a-b==0 || a=='*' || a=='?' || b=='*' || b=='?')    return true;
        return false;
    }
}