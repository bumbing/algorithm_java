public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        for(int[] update: updates){
            diff[update[0]] += update[2];
            diff[update[1]] -= update[2];
        }
        int[] result = new int[length];
        for(int i=0; i)
    }
}