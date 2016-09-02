public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //dfs
        if(prerequisites==null) return false;
        if(numCourses==0)   return true;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int [] visited = new int[numCourses];
        for(int[] preq: prerequisites){
            ArrayList<Integer> list = map.getOrDefault(preq[1], new ArrayList<Integer>());
            list.add(preq[0]);
            map.put(preq[1], list);//preq[1]->preq[0]
        }
        for(int i=0; i<numCourses; i++){
            if(!dfs(i, map, visited))    return false;
        }
        return true;
    }
    
    public boolean dfs(int course, Map<Integer, ArrayList<Integer>> map, int[] visited){
        visited[course] = 1;
        ArrayList<Integer> preqs = map.get(course);
        for(int preq: preqs){
            if(visited[preq]==1)  return false;
            if(visited[preq]==2)  continue;
            if(!dfs(preq, map, visited))    return false;
        }
        visited[course] = 2;
        return true;
    }
}