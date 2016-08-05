public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] min = new int[primes.length];
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        while(result.size()<n){
            int temp = Integer.MAX_VALUE;
            int index=0;
            for(int num:primes){
                temp = Math.min(temp, result.get(index)*num);
                index++;
            }
            result.add(min);
            index=0;
            for(int i=0; i<primes.length; i++){
                if(temp/primes[i]==result.get(min[i]))  min[i] += 1;
            }
        }
        return result.get(n-1);
    }
}