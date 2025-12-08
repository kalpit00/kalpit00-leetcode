// Last updated: 12/8/2025, 3:50:20 AM
1class LRUCache {
2    private class Node {
3        int key, value;
4        Node prev, next;
5        Node(int key, int value) {
6            this.key = key;
7            this.value = value;
8        }
9    }
10    private int size;
11    private int capacity;
12    private Node[] map;
13    private Node head, tail;
14    
15    public LRUCache(int capacity) {
16        this.size = 0;
17        this.capacity = capacity;
18        this.map = new Node[10001];
19        this.head = new Node(0, 0);
20        this.tail = new Node(0, 0);
21        head.next = tail;
22        tail.prev = head;
23    }
24    
25    public int get(int key) {
26        if (map[key] == null) {
27            return -1;
28        }
29        Node node = map[key];
30        remove(node);
31        insert(node);
32        return node.value;
33    }
34    
35    public void put(int key, int value) {
36        if (map[key] != null) {
37            remove(map[key]);
38        }
39        if (size == capacity) {
40            remove(tail.prev);
41        }
42        insert(new Node(key, value));
43    }
44    
45    private void remove(Node node) {
46        map[node.key] = null;
47        size--;
48        node.prev.next = node.next;
49        node.next.prev = node.prev;
50    }
51    
52    private void insert(Node node) {
53        map[node.key] = node;
54        size++;
55        node.next = head.next;
56        node.prev = head;
57        // head.next.prev = node;
58        node.next.prev = node;
59        // head.next = node;
60        node.prev.next = node;
61    }
62}