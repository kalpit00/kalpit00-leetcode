// Last updated: 4/16/2025, 2:55:58 AM
class TimeMap {
    class Node {
        int timestamp;
        String value;
        public Node(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    Map<String, List<Node>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Node(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Node> list = map.get(key);
        if (list == null) {
            return ""; // no such key exists
        }
        int index = binarySearchFloor(list, timestamp);
        return index != -1 ? list.get(index).value : "";
    }

    public int binarySearchFloor(List<Node> nums, int target) {
        int n = nums.size(), start = 0, end = n - 1, ans = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums.get(mid).timestamp <= target) {
                ans = mid; // potential candidate
                start = mid + 1; // find one closer to target to the right
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
