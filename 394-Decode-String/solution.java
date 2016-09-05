public class Solution {
    class Str{
        String s;
        int num;
        public Str(int num){    this.num = num; }
    }
    
    public String decodeString(String s) {
        int head = 0, tail = 0;
        Stack<Str> stack = new Stack();
        String st = new String();
        stack.push(new Str(1));
        while(tail<s.length()){
            if(s.charAt(tail)=='['){
                int num = Integer.valueOf(s.substring(head, tail));
                stack.push(new Str(num));   
                head = tail + 1;
            } else if(s.charAt(tail)==']'){
                Str temp = stack.pop();
                for(int i=0; i<temp.num; i++)   stack.peek().s += temp.s;
                head = tail + 1;
            } else if(Character.isLetter(s.charAt(tail))){
                stack.peek().s += s.charAt(tail);
                head++;
            }
            tail++;
        }
        return stack.peek().s;
    }
}