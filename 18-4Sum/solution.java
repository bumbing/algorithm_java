public class Solution {
public List<List<Integer>> fourSum(int[] num, int target) {
        // Since we use set here, we don't need to dedup data
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Arrays.sort(num);
        Map<Integer, Set<Pair>> map = new HashMap<Integer, Set<Pair>>();
        for (int i=0; i<num.length; i++) {
            // Note the order of these two for-loops is critical
            for (int j=i+1; j<num.length; j++) {
                int pairSum = num[i] + num[j];
                if (map.containsKey(target - pairSum)) {
                    for (Pair p : map.get(target - pairSum)) {
                        List l = new LinkedList();
                        l.add(p.first);
                        l.add(p.second);
                        l.add(num[i]);
                        l.add(num[j]);
                        result.add(l);
                    }
                }
            }
            for (int j=0; j<i; j++) {
                int a = num[j], b = num[i];
                if (!map.containsKey(a+b)) {
                    map.put(a+b, new HashSet());
                }
                map.get(a+b).add(new Pair(a, b));
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
    class Pair {
        Integer first;
        Integer second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public int hashCode() {
            return this.first.hashCode() + this.second.hashCode();
        }
        @Override
        public boolean equals(Object d){ 
            if (!(d instanceof Pair)) {
                return false;
            }
            Pair p = (Pair) d;
            return (this.first == p.first) && (this.second == p.second);
        }
    }
}