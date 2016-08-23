public class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null)  return false;
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)!='*')
                break;
            else
                match[0][i]=true;
        }
        
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<p.length(); j++){
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')    match[i+1][j+1] = match[i][j];
                else if(p.charAt(j)=='*'){
                    match[i+1][j+1] = match[i+1][j] || match[i][j+1]; 
                }
            }
        }
        return match[s.length()][p.length()];
    }
}


