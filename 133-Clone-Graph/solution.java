/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)    return node;
        Map<UndirectedGraphNode, UndirectedGraphNode> map =new HashMap<>();
        Stack<UndirectedGraphNode> stack = new Stack();
        stack.push(node);
        while(!stack.isEmpty()){
            UndirectedGraphNode temp = stack.pop();
            UndirectedGraphNode temp2;
            if(map.containsKey(temp)){
                temp2 = map.get(temp);
            }else{
                temp2 = new UndirectedGraphNode(temp.label);
                map.put(temp, temp2);
            }
            
            for(UndirectedGraphNode n: temp.neighbors){
                if(!map.containsKey(n)){
                    map.put(n, new UndirectedGraphNode(n.label));
                    stack.push(n);
                }
                temp2.neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}