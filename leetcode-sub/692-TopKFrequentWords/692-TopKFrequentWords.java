// Last updated: 8/2/2025, 2:59:34 PM
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int n = map.size(), idx = 0;
        Node[] nums = new Node[n];
        for (String key : map.keySet()) {
            nums[idx++] = new Node(key, map.get(key));
        }
        quickSelect(nums, 0, n - 1, n - k);
        List<Node> topK = new ArrayList<>();
        for (int i = n - k; i < n; i++) {
            topK.add(nums[i]);
        }
        Collections.sort(topK, (a, b) -> a.val != b.val ? b.val - a.val : a.word.compareTo(b.word));
        List<String> res = new ArrayList<>();
        for (Node node : topK) {
            res.add(node.word);
        }
        return res;
    }
    private String quickSelect(Node[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start].word;
        } // take random pivot choice between index [start .. end]
        int pivotIndex = start + new Random().nextInt(end - start + 1);
        int pivot[] = partition(nums, start, end, pivotIndex);
        if (pivot[0] > k) {
            return quickSelect(nums, start, pivot[0] - 1, k);
        }
        else if (pivot[1] < k) {
            return quickSelect(nums, pivot[1] + 1, end, k);
        }
        else {
            return nums[k].word;
        }
    }
    // Dutch National Flag Algorithm
    private int[] partition(Node[] nums, int start, int end, int pivotIndex) {
        Node pivot = nums[pivotIndex]; 
        int i = start, idx = start, j = end;
        while (idx <= j && i < j) {
            if (compare(nums[idx], pivot) < 0) {
                swap(nums, i++, idx++);
            }
            else if (compare(nums[idx], pivot) > 0) {
                swap(nums, j--, idx);
            }
            else {
                idx++;
            }
        }
        return new int[]{i, j};
    }
    private int compare(Node s1, Node s2) {
        return s1.val != s2.val ? s1.val - s2.val : 
        s2.word.compareTo(s1.word); 
    }
    private void swap(Node[] nums, int i, int j) {
        Node temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    class Node {
        String word;
        int val;
        public Node(String word, int val) {
            this.word = word;
            this.val = val;
        }
    }
}