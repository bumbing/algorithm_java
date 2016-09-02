public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> stack = new Stack();
        int[] result = new int[numCourses];
        if(numCourses==0)    return result;
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] visit = new int[numCourses];
        for(int[] preq: prerequisites){
            ArrayList<Integer> list = map.getOrDefault(preq[1], new ArrayList<Integer>());
            list.add(preq[0]);
            map.put(preq[1], list);
        }
        for(int i=0; i<numCourses; i++){
            if(!dfs(i, visit, map, stack))   return new int[0];
        }
        
        for(int i=0; !stack.isEmpty(); i++){
            result[i] = stack.pop();
        }
        return result;
    }
    
    public boolean dfs(int i, int[] visit, Map<Integer, ArrayList<Integer>> map, Stack<Integer> stack){
        if(visit[i]==2) return true;
        if(map.containsKey(i)){
            visit[i] = 1;
            for(int course: map.get(i)){
                if(visit[course]==2)    continue;
                if(visit[course]==1)    return false;
                if(!dfs(course, visit, map, stack)) return false;
            }
        }
        visit[i] = 2;
        stack.push(i);
        return true;
    }
}