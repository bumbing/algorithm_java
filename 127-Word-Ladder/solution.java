public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        LinkedList<String> beginq = new LinkedList<>(), endq = new LinkedList<>();
        Map<String, Integer> beginMap = new HashMap<>(), endMap = new HashMap<>();
        beginq.offer(beginWord);
        endq.offer(endWord);
        beginMap.put(beginWord, 1);
        endMap.put(endWord, 1);
        wordList.remove(beginWord);
        wordList.remove(endWord);
        while(!beginq.isEmpty() && !endq.isEmpty()){
            String temp;
            int dis;
            if(beginMap.size()<endMap.size()){
                temp = beginq.pop();
                dis = helper(temp, beginMap, endMap, wordList, beginq);
            }else{
                temp = endq.pop();
                dis = helper(temp, endMap, beginMap, wordList, endq);
            }
            if(dis>0)   return dis;
            
        }
        return 0;
    }
    
    public int helper(String word, Map<String, Integer> begin, Map<String, Integer> end, Set<String> wordList, LinkedList<String> q){
        char[] c = word.toCharArray();
        for(int i=0; i<c.length; i++){
            char temp = c[i];
            for(char x = 'a'; x<='z'; x++){
                c[i] = x;
                String st = String.valueOf(c);
                if(end.containsKey(st)){
                    return begin.get(word) + end.get(st);
                }
                if(wordList.contains(st)){
                    wordList.remove(st);
                    begin.put(st, begin.get(word)+1);
                    q.offer(st);
                }
            }
        }
        return -1;
    }
}