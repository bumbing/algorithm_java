public class TwoSum {
    Map<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> arr = new ArrayList<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(!map.containsKey(number))    arr.add(number);
	    map.put(number, map.getOrDefault(number, 0)+1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(int num: arr){
	        if(num*2==value && map.get(num)==1)   continue;
	        if(map.containsKey(value-num))  return true;
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);