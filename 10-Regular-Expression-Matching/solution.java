public class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null)  return false;
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && match[0][i-1]) {
                match[0][i+1] = true;
            }
        }

        for(int i=0; i<s.length(); i++){
            for(int j=0; j<p.length(); j++){
                
                if(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.'){
                    match[i+1][j+1] = match[i][j];
                }else if(p.charAt(j)=='*'){
                    if(p.charAt(j-1)==s.charAt(i)||p.charAt(j-1)=='.'){
                        match[i+1][j+1] = match[i+1][j-1] || match[i][j-1] || match[i][j+1];//nth, 1, multiple
                    }else{
                        match[i+1][j+1] = match[i+1][j-1]; //this is do nothing
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
