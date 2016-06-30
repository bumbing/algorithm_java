public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for(int i=2; i<n; i++)  isPrime[i] = true;
        int result = 0;
        for(int i=2; i*i<n; i++){
            if(isPrime[i] == false) continue;
            for(int j=i; j*i<n; j++){
                isPrime[i*j] = false;
            }
        }
        for(boolean temp: isPrime){
            if(temp)    result++;
        }
        return result;
    }
}