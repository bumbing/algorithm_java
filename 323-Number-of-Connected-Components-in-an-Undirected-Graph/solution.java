public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        int result = n;
        for(int i=0; i<n; i++)  root[i] = i;
        for(int[] edge: edges){
            if(findroot(root, edge[0]) != findroot(root, edge[1])){
                result--;
                union(root, edge[0], edge[1]);
            }
        }
        return result;
    }
    
    public int findroot(int[] root, int num){
        while(root[num]!=num){
            int temp = root[num];
            root[num] = root[temp];
            root = root[num];
        }
        return num;
    }
    
    public void union(int[] root, int a, int b){
        int x = findroot(root, a);
        int y = findroot(root, b);
        root[x] = y;
    }
}