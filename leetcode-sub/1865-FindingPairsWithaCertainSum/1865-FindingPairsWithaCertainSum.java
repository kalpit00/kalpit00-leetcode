// Last updated: 7/5/2025, 8:28:38 PM
class FindSumPairs {
    private int[] nums1, nums2;
    private Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.map = new HashMap<>();
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        map.put(oldVal, map.get(oldVal) - 1);
        nums2[index] += val;
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int total) {
        int ans = 0;
        for (int num : nums1) {
            ans += map.getOrDefault(total - num, 0);
        }
        return ans;
    }
}