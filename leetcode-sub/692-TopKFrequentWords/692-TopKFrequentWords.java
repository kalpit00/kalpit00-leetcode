// Last updated: 8/2/2025, 2:57:00 PM
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
            (a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.addFirst(heap.poll().getKey());
        }
        return res;
    }
}