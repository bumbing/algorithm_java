public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0, index=0;
        while(index<a || index<b || carry!=0){
            if(index<a)     carry += a.charAt(a.length()-index-1);
            if(index<b)     carry += b.charAt(b.length()-index-1);
            result = carry%2 + result;
            carry /= 2;
        }
        return result.toString();
    }
}