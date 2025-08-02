// Last updated: 8/2/2025, 5:25:26 AM
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int num : basket1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            min = Math.min(min, num);
        }
        for (int num : basket2) {
            map.put(num, map.getOrDefault(num, 0) - 1);
            min = Math.min(min, num);
        }
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count % 2 != 0) {
                return -1;
            }
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                list.add(key);
            }
        }
        int n = list.size();
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = list.get(i);
        }
        quickSelect(nums, 0, n - 1, (n - 1) / 2);
        long res = 0;
        for (int i = 0; i < n / 2; i++) {
            res += Math.min(2 * min, nums[i]);
        }
        return res;
    }
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start];
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
            return nums[k];
        }
    }
    // Dutch National Flag Algorithm
    private int[] partition(int[] nums, int start, int end, int pivotIndex) {
        int pivot = nums[pivotIndex]; 
        int i = start, idx = start, j = end;
        while (idx <= j && i < j) {
            if (nums[idx] < pivot) {
                swap(nums, i++, idx++);
            }
            else if (nums[idx] > pivot) {
                swap(nums, j--, idx);
            }
            else {
                idx++;
            }
        }
        return new int[]{i, j};
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}