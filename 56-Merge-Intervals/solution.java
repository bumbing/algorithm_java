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
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a,b)->a.start-b.start);
        List<Interval> result = new ArrayList<>();
        if(intervals.size()==0) return result;
        Interval cur = new Interval(intervals.get(0).start, intervals.get(0).end);
        for(Interval interval: intervals){
            if(!isOverlap(cur, interval)){
                result.add(cur);
                cur = new Interval(interval.start, interval.end);
            }    
            else{
                cur.start = Math.min(cur.start, interval.start);
                cur.end = Math.max(cur.end, interval.end);
            }
        }
        result.add(cur);
        return result;
    }
    public boolean isOverlap(Interval a, Interval b){
        if(a.start>b.end || b.start>a.end)  return false;
        else return true;
    }
}