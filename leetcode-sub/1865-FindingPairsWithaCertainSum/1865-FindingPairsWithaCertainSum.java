// Last updated: 7/5/2025, 8:30:25 PM
class FindSumPairs {

    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> nums2Freqs;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.nums2Freqs = new HashMap<>();
        for (int num : nums2) {
            nums2Freqs.put(num, nums2Freqs.getOrDefault(num, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int prevValue = nums2[index];
        nums2Freqs.put(prevValue, nums2Freqs.get(prevValue) - 1);
        int newValue = prevValue + val;
        nums2Freqs.put(newValue, nums2Freqs.getOrDefault(newValue, 0) + 1);
        nums2[index] = newValue;
    }
    
    public int count(int tot) {
        int cnt = 0;
        for (int num : nums1) {
            int diff = tot - num;
            cnt += nums2Freqs.getOrDefault(diff, 0);
        }
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */