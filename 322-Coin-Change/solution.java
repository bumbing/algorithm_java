public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount+1];
        for(int i=1; i<=amount; i++){
            result[i] = -1;
            for(int j: coins){
                if(i-j>=0){
                    if(result[i-j]!=-1 && result[i]!=-1)    result[i] = Math.min(result[i], result[i-j]+1);
                    else if(result[i-j]!=-1)    result[i] = result[i-j]+1;
                }
            }
        }
        return result[amount];
    }
}