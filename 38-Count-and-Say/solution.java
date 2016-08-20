public class Solution {
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder("1");
        int count = 1;
        while(count<n){
            result = helper(result);
            count++;
        }
        return result.toString();
    }
    
    public StringBuilder helper(StringBuilder result){
        StringBuilder temp = new StringBuilder();
        int count = 0, index = 0;
        char c = result.charAt(0);
        while(index<result.length()){
            if(c == result.charAt(index)){
                count++;
                index++;
            }else{
                temp.append(count);
                temp.append(c);
                count = 0;
                c = result.charAt(index);
            }
        }
        temp.append(count);
                temp.append(c);
        return temp;
    }
}