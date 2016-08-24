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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        for(int i=0; i<intervals.size(); ){
            Interval temp = intervals.get(i);
            if(!hasOverlap(newInterval, temp)){
                if(temp.start>newInterval.start){
                    intervals.add(i, newInterval);
                }
                i++;
            }else{
                newInterval.start = Math.min(newInterval.start, temp.start);
                newInterval.end = Math.max(newInterval.end, temp.end);
                intervals.remove(i);
            }
        }
        return intervals;
    }
    
    public boolean hasOverlap(Interval a, Interval b){
        if(a.start<=b.end || b.start<=a.end)    return true;
        else return false;
    }
}