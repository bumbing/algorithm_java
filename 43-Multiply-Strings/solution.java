public class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
        int[] result = new int[l1+l2+1];
        for(int i=0; i<l1; i++){
            for(int j=0; j<l2; j++){
                result[i+j+1] += (int)(n1[i]-'0') * (n2[j]-'0');
            }
        }
        int carry = 0;
        for(int i=result.length-1; i>=0; i--){
            result[i] += carry;
            carry = result[i] / 10;
            result[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(result[index]==0 && index<result.length-1) index++;
        while(index<result.length){
            sb.append(result[index]);
            index++;
        }
        return sb.toString();
    }
}