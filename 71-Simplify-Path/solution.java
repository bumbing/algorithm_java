public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        int head = 0, tail = 0;
        while(head<path.length()){
            if(tail==path.length() || path.charAt(tail)=='/'){
                if(head==tail){
                    head++;
                    tail++;
                }else{
                    if(path.substring(head, tail).equals(".")){
                        head = tail++;
                    }else if(path.substring(head, tail).equals("..")){
                        if(!stack.isEmpty()) stack.pop();
                        head = tail++;
                    }else{
                        stack.push(path.substring(head, tail));
                        head = tail++;
                    }
                }
            }
            else    tail++;
        }
        if(stack.isEmpty()) return "/";
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
            result.insert(0, "/");
        }
        return result.toString();
    }
}