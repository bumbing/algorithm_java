public class Solution {
    public int nthUglyNumber(int n) {
        Set<Integer> traversed = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] array = {2, 3, 5};
        pq.offer(1);
        traversed.add(1);
        int count=0;
        while(count<n){
            count++;
            int temp = pq.poll();
            if(count==n)    return temp;
            for(int num: array){
                if(!traversed.contains(temp*num) && temp*num>0){
                    traversed.add(temp*num);
                    pq.offer(temp*num);
                }
            }     
        }
        return -1;
    }
}