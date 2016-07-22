public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0)   return word2.length();
        if(word2.length()==0)   return word1.length();
        int[][] result = new int [word1.length()][word2.length()];
        for(int i=0; i<word1.length(); i++){
            for(int j=0; j<word2.length(); j++){
                char x = word1.charAt(i), y = word2.charAt(j);
                if(i==0 && j==0){
                    result[i][j] = ((x==y)?0:1);
                }else if(i==0){
                    result[i][j] = Math.min(j + 1 - ((x==y)?1:0), result[i][j-1] + 1);
                }else if(j==0){
                    result[i][j] = Math.min(i + 1 - ((x==y)?1:0), result[i-1][j] + 1);
                }else{
                    result[i][j] = Math.min(result[i-1][j], result[i][j-1])+1;
                    result[i][j] = Math.min(result[i][j], result[i-1][j-1]+((x==y)?0:1));
                }
            }
        }
        return result[word1.length()-1][word2.length()-1];
    }
}