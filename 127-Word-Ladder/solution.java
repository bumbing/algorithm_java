public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        wordList.remove(beginWord);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while(!q.isEmpty()){
            String st = q.pop();
            char[] c = st.toCharArray();
            for(int i=0; i<c.length; i++){
                char tmp = c[i];
                for(char tmpc = 'a'; tmpc<='z'; tmpc++){
                    c[i] = tmpc;
                    String st2 = String.valueOf(c);
                    if(wordList.contains(st2)){
                        if(st2.equals(endWord)) return map.get(st)+1;
                        wordList.remove(st2);
                        q.offer(st2);
                        map.put(st2, map.get(st)+1);
                    }
                }
                c[i] = tmp;
            }
        }
        return 0;
    }
}