public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if(rowIndex==0)  return list;
        list.add(1);
        while(--rowIndex != 0){
            int carry = 0;
            for(int i=0; i<list.size(); i++){
                int temp = list.get(i);
                list.set(i, carry+temp);
                carry = temp;
            }
            list.add(carry);
            
        }
        return list;
    }
}

