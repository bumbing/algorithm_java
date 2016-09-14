public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        dfs(result, word.toCharArray(), 0, 0, new StringBuilder());
        return result;
    }
    
    private void dfs(List<String> result, char[] word, int index, int count, StringBuilder st){
        //if index==word.length
        if(index==word.length){
            if(count!=0)    st.append(count);
            result.add(st.toString());
            return;
        }  
        //else dfs
        while(index<word.length){
            StringBuilder temp = new StringBuilder(st);
            if(count!=0){
                dfs(result, word, index+1, count+1, new StringBuilder(st));
                temp.append(count);
            }else{
                dfs(result, word, index+1, 1, new StringBuilder(st));
            }
            temp.append(word[index]);
            dfs(result, word, index+1, 0, temp);
        }
        return;
    }
}