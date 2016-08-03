public class Solution {
    public String reverseWords(String s) {
        StringBuilder st = new StringBuilder(s.trim());
        int head=0, tail=0;
        while(head<st.length()){
            if(st.charAt(head)==' '){
                while(tail<st.length() && st.charAt(tail)==' '){
                    tail++;
                }
                if(tail!=head)  st = st.delete(head+1, tail);
                head = head+1;
                tail = head;
            }else{
                while(tail<st.length()&&st.charAt(tail)!=' '){
                    tail++;
                }
                swap(st, head, tail-1);
                head = tail;
            }
            
        }
        st = st.reverse();
        return st.toString();
    }
    private void swap(StringBuilder s, int head, int tail){
        while(head<tail){
            char tmp = s.charAt(head);
            s.setCharAt(head, s.charAt(tail));
            s.setCharAt(tail, tmp);
            head++;
            tail--;
        }
        return;
    }
}