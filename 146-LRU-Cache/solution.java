public class LRUCache {
    class Node{
        int val;
        Node prev, next;
        public Node(int val){
            this.val = val;
        }
    }
    Node head = new Node(0), tail = new Node(0);
    Map<Integer, Node> map = new HashMap<>();
    int size;
    public LRUCache(int capacity) {
        this.size = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if(!this.map.containsKey(key))    return -1;
        Node cur = this.map.get(key);
        cur.next.prev = cur.prev;
        cur.prev.next = cur.next;//grab this node
        cur.next = this.head.next;
        this.head.next.prev = cur;
        this.head.next = cur;
        cur.prev = this.head;//insert next to head
        return cur.val;
    }
    
    public void set(int key, int value) {
        Node cur = null;
        if(this.map.containsKey(key)){
            cur = this.map.get(key);
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
            cur.val = value;
        } else {
            cur = new Node(value);
        }
        this.map.put(key, cur);
        cur.next = this.head.next;
        this.head.next.prev = cur;
        this.head.next = cur;
        cur.prev = this.head;
    }
}