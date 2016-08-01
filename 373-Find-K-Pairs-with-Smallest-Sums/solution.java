public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        if(nums1.length==0 || nums2.length==0){
            return result;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0; i<nums1.length; i++){
            queue.offer(new int[]{nums1[i]+nums2[0], 0, i});
        }
        while(k-->0 && !queue.isEmpty()){
            int[] temp = queue.poll();
            result.add(new int[]{nums1[temp[2]], nums2[temp[1]]});
            if(temp[1]==nums2.length-1) continue;
            queue.offer(new int[]{temp[0]+nums2[temp[1]+1]-nums2[temp[1]], temp[1]+1, temp[2]});
        }
        return result;
    }
}