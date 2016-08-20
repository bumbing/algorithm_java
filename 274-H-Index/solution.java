public class Solution {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length+1];
        for(int num: citations){
            if(num>=citations.length){
                count[count.length-1]++;
            }else{
                count[num]++;
            }
        }
        int temp = 0;
        for(int i=count.length-1; i>=0; i--){
            temp += count[i];
            count[i] = temp;
        }
        for(int i=count.length-1; i>=0; i--){
            if(count[i]>=i)   return i;
        }
        return 0;
    }
}