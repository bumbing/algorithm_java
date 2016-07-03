public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        //考点有 long to avoid overflow; 负号要在绝对值的除法前面加，^的用法；numerator=0的特殊情况
        if(numerator == 0)  return "0";
        Map<Long, Integer> map = new HashMap<>();
        //The key is residue, value is index
        int index = 0;
        long num1 = Math.abs((long)numerator);
        long num2 = Math.abs((long)denominator);
        String number1 = new String( (((numerator > 0) ^ (denominator > 0)) ? "-" : "") + Long.toString(num1/num2) );
        num1 %= num2;
        StringBuilder sb = new StringBuilder();
        map.put(num1, index++);
        while(num1 != 0){
            num1 *= 10;
            long residue = num1%num2;
            if(map.containsKey(residue)){
                sb.insert(map.get(residue), "(");
                sb.append(num1/num2);
                sb.append(")");
                break;
            }else {
                sb.append(num1/num2);
                num1 = residue;
                map.put(residue, index);
                index++;
            }
        }
        if(sb.length() != 0)    sb.insert(0, '.');
        sb.insert(0, number1);
        return sb.toString();
    }
}