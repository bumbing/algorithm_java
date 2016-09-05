public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l=0, cnt=0;
        List<String> result = new ArrayList<String>();
        Set<String> set = new HashSet<>();
        for(char c: s.toCharArray()){
            if(c=='(')  l++;
            if(c==')' && l>0){
                cnt++;
                l--;
            }
        }
        cnt -= l;
        dfs(s, 0, 0, 0, cnt, result, "", set);
        return result;
    }
    
    public void dfs(String s, int index, int l, int r, int cnt, List<String> result, String str, Set<String> set){
        if(cnt-l+cnt-r>s.length()-index)   return;
        if(index>=s.length()){
            if(l==cnt && r==cnt && !set.contains(str)){
                result.add(str);
                set.add(str);
            }   
            return;
        }    
        if(s.charAt(index)=='('){
            dfs(s, index+1, l, r, cnt, result, str, set); 
            if(l<cnt)   dfs(s, index+1, l+1, r, cnt, result, str+"(", set);
            
        }else if(s.charAt(index)==')'){
            if(r<cnt && r<l)    dfs(s, index+1, l, r+1, cnt, result, str+")", set);
            dfs(s, index+1, l, r, cnt, result, str, set);
            
        }else{
            String temp = str + s.charAt(index);
            dfs(s, index+1, l, r, cnt, result, temp, set);
        }
    }
}