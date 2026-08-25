class LRUCache {

    Node list, tail;
    Map<Integer, Node> rec;
    int cap;

    public LRUCache(int capacity) {
        this.cap= capacity;
        list= new Node(-1,-1);
        tail= new Node(-1,-1);

        list.next= tail;
        tail.prev= list;

        rec= new HashMap<>();
    }
    
    public int get(int key) {
        if(!rec.containsKey(key)) return -1;

        Node curr= rec.get(key);
        shiftToHead(curr);

        return curr.value;
    }
    
    public void shiftToHead(Node curr){
        remove(curr);
        add(curr);
    }

    public void remove(Node curr){
        curr.prev.next= curr.next;
        curr.next.prev= curr.prev;
    }

    public void add(Node curr){
        curr.next= list.next;
        list.next.prev= curr;
        list.next= curr;
        curr.prev= list;
    }

    public void put(int key, int value) {
        if(rec.containsKey(key)){
            Node newNode= rec.get(key);
            newNode.value= value;

            shiftToHead(newNode);
            rec.put(key, newNode);
        }else if(cap==rec.size()){
            Node newNode= new Node(key, value);

            rec.remove(tail.prev.key);
            remove(tail.prev);

            rec.put(key, newNode);
            add(newNode);
        }else{
            Node newNode= new Node(key,value);
            add(newNode);
            rec.put(key,newNode);
        }
    }
}

class Node{
    int key, value;
    Node next, prev;

    Node(){}

    Node(int key, int value){
        this.key= key;
        this.value= value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */