// Last updated: 6/8/2025, 2:19:18 AM
class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    boolean even = true;
    public MedianFinder() {
        
    }
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        even = !even;
    }
    public double findMedian() {
        return (!even) ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}