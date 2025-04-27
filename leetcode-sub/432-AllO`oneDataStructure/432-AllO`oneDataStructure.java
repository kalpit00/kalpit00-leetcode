// Last updated: 4/27/2025, 1:24:24 PM
class AllOne {
    private class Node {
        int freq;
        Set<String> keys;
        Node prev, next;
        
        Node(int freq) {
            this.freq = freq;
            this.keys = new LinkedHashSet<>();
        }
    }
    
    private Map<String, Integer> freqMap;
    private Map<Integer, Node> bucketMap;
    private Node head, tail;

    public AllOne() {
        freqMap = new HashMap<>();
        bucketMap = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        int freq = freqMap.getOrDefault(key, 0);
        freqMap.put(key, freq + 1);
        Node curr = bucketMap.get(freq);
        Node next = bucketMap.get(freq + 1);
        if (next == null) {
            next = new Node(freq + 1);
            bucketMap.put(freq + 1, next);
            insertAfter(curr == null ? head : curr, next);
        }
        next.keys.add(key);
        if (curr != null) {
            curr.keys.remove(key);
            if (curr.keys.isEmpty()) {
                remove(curr);
                bucketMap.remove(freq);
            }
        }
    }
    
    public void dec(String key) {
        if (!freqMap.containsKey(key)) return;
        int freq = freqMap.get(key);
        Node curr = bucketMap.get(freq);
        if (freq == 1) {
            freqMap.remove(key);
        } else {
            freqMap.put(key, freq - 1);
            Node prev = bucketMap.get(freq - 1);
            if (prev == null) {
                prev = new Node(freq - 1);
                bucketMap.put(freq - 1, prev);
                insertBefore(curr, prev);
            }
            prev.keys.add(key);
        }
        curr.keys.remove(key);
        if (curr.keys.isEmpty()) {
            remove(curr);
            bucketMap.remove(freq);
        }
    }
    
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
    
    private void insertAfter(Node prev, Node node) {
        node.prev = prev;
        node.next = prev.next;
        prev.next.prev = node;
        prev.next = node;
    }
    
    private void insertBefore(Node next, Node node) {
        node.next = next;
        node.prev = next.prev;
        next.prev.next = node;
        next.prev = node;
    }
    
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
