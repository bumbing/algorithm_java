public class MovingAverage {
    int[] nums;
    int pointer, sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.nums = new int[size];
        this.pointer = 0;
        this.sum = 0;
    }
    
    public double next(int val) {
        double size = this.nums.size;
        this.sum += val - this.nums[pointer];
        this.nums[pointer] = val;
        this.pointer = (this.pointer+1)%size;
        return (double) sum/size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */