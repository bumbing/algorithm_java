public class Solution {
    public int superPow(int a, int[] b) {
        if(a==0 || a==1)    return a;
        a %= 1337;
        long result = 1;
        int[] residue = new int[10];
        int temp = 1;
        for(int i=0; i<10; i++){
            residue[i] = temp % 1337;
            temp = (temp * a) % 1337;
        }
        for(int i:b){
            long temp2 = 1;
            for(int j=0; j<10; j++){
                temp2 = (temp2 * result) %1337;
            }
            result = temp2;
            result = (result * residue[i]) % 1337;
        }
        return (int)result;
    }
}