public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0)  return 0;
        int result = 0;
        int min = prices[0];
        for(int i=0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            result = Math.max(result, prices[i] - min);
        }
        return result;
    }
}