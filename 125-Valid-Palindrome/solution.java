public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null)   return false;
        s = s.toLowerCase();
        int head = 0, tail = s.length()-1;
        while(head<=tail){
            char a=s.charAt(head), b=s.charAt(tail);
            if(!Character.isLetterOrDigit(a)){
                head++;
                continue;
            }
            if(!Character.isLetterOrDigit(b)){
                tail--;
                continue;
            }
            
            if(s.charAt(head) != s.charAt(tail))    return false;
            head++;
            tail--;
        }
        return true;
    }
}