public class PhoneDirectory {
    private boolean[] numbers;
    private int index = 0;
    private Deque<Integer> stack;
    
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
       numbers = new boolean[maxNumbers] ;
       Arrays.fill(numbers, true);
       stack = new ArrayDeque<Integer>();
       
       for(int i = 0; i < maxNumbers; i++) {
           stack.push(i);
       }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(stack.size() == 0)
            return -1;
        int number = stack.pop();    
        numbers[number] = false;
        return number;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return numbers[number];
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(!numbers[number]) {
            numbers[number] = true;
            stack.push(number);
        }
    }
}