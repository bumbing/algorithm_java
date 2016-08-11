/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Integer> start = new PriorityQueue<>();
        PriorityQueue<Integer> end = new PriorityQueue<>();
        for(Interval interval: intervals){
            start.offer(interval.start);
            end.offer(interval.end);
        }
        int cur = 0, max = 0;
        while(!start.isEmpty()){
            if(start.peek()<end.peek()){
                start.poll();
                cur++;
            }else{
                end.poll();
                cur--;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}