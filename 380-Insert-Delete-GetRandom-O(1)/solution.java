public class RandomizedSet {
    public class Node{
        int val;
        public Node(int val){
            this.val = val; 
        }
    }
    
    Map<Integer, Node> map = new HashMap<>();
    ArrayList<Node> array = new ArrayList<>();
    Random ran = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        map = this.map;
        array = this.array;
        if(map.containsKey(val))    return false;
        Node temp = new Node(val);
        map.put(val, temp);
        array.add(temp);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        map = this.map;
        array = this.array;
        if(!map.containsKey(val))  return false;
        Node temp = map.get(val);
        Node swap = array.get(array.size()-1);
        temp.val = swap.val;
        //Need to consider when the tail element is the one, swap it then delete original one
        map.put(swap.val, temp);//Otherwise this might put it back
        array.remove(array.size()-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if(this.array.size()==0)    return -1;
        array = this.array;
        int num = this.ran.nextInt(array.size());
        return array.get(num).val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */