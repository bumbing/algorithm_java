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
    public boolean canAttendMeetings(Interval[] intervals) {
        PriorityQueue<Interval> list = new PriorityQueue<>((a,b)->a.start-b.start);
        for(Interval temp : intervals)  list.offer(temp);
        int time = Integer.MIN_VALUE;
        while(!list.isEmpty()){
            Interval cur = list.poll();
            if(cur.start<time)  return false;
            time = cur.end;
        }
        return true;
    }
}