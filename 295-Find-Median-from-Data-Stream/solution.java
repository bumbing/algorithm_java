public class MedianFinder {
    PriorityQueue<Integer> max = new PriorityQueue();
    PriorityQueue<Integer> min = new PriorityQueue(Collections.	reverseOrder());
    //(a,b)->a[0]-b[0]
    // Adds a number into the data structure.
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        if(min.size()>max.size())   max.add(min.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        return min.size()==max.size()?(double)(min.peek()+max.peek())/2:(double)max.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();