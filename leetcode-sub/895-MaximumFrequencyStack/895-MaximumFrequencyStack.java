// Last updated: 5/24/2025, 12:43:32 AM
class FreqStack {
    Map<Integer,Integer> map;
    PriorityQueue<int[]> maxHeap;
    int size;
    public FreqStack() {
        size = 0;
        map = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> a[1] != b[1] ? b[1] - a[1] : 
        b[2] - a[2]); // <val, freq, size>
    }  // sort on freq first, maxHeap, then on height/size of stack!
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        size++; // grow the stack vertically, used for tiebreakers!
        maxHeap.offer(new int[]{val, map.get(val), size});
    }
    
    public int pop() {
        int val = maxHeap.poll()[0];
        map.put(val, map.getOrDefault(val, 0) - 1);
        return val;
    }
}