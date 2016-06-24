public class Solution {
    public boolean isMatch(String s, String p) {
        char[] ca1 = s.toCharArray();
        char[] ca2 = p.toCharArray();
        if(ca1.length == 0 || ca2.length == 0){
            if(ca1.length == ca2.length)    return true;
            else if(ca1.length == 0){
                for(char c : ca2)   if(ca2!='*')    return false;
                return true;
            }else {
                for(char c : ca1)   if(ca1!='*')    return false;
                return true;
            }
        }
        
        boolean[][] result = new boolean[ca1.length][ca2.length];
        for(int i=0; i<ca1.length; i++){
            for(int j=0; j<ca2.length; j++){
                boolean temp = compare(ca1[i], ca2[j]);
                if(i==0 && j==0){
                    result[i][j] = temp;
                }else if(i==0){
                    result[i][j] = result[i][j-1] & temp;
                }else if(j==0){
                    result[i][j] = result[i-1][j] & temp;
                }else{
                    result[i][j] = temp & (result[i-1][j] | result[i][j-1]);
                }
            }
        }
        return result[ca1.length-1][ca2.length-1];
    }
    
    private boolean compare(char a, char b){
        if(a-b == 0)    return true;
        if(a =='*' || a=='?' || b =='*' || b=='?')    return true;
        return false;
    }
}