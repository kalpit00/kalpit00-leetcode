// Last updated: 10/24/2025, 2:44:12 AM
class Solution {
    public int nextBeautifulNumber(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(1224444);
        String[] map = {"1", "22", "122", "333", "1333", "4444", "14444",
        "22333", "55555", "122333", "155555", "224444", "666666"};
        for (String s : map) {
            int num = Integer.parseInt(s), i = 0;
            int[] nums = new int[s.length()];
            while (num > 0) {
                nums[i++] = num % 10;
                num /= 10;
            }
            permuteUnique(nums, set);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.get(upper_bound(list, n));
    }
    private int upper_bound(List<Integer> nums, int target) {
        int n = nums.size(), start = 0, end = n - 1, ans = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) > target) {
                ans = mid;
                end = mid - 1;
            }                
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
    public void permuteUnique(int[] nums, Set<Integer> set) {
        int n = nums.length;
        // Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        backtrack(0, n, list, set, nums);
    }
    
    public void backtrack(int mask, int n,
    List<Integer> list, Set<Integer> set, int[] nums) {
        if (list.size() >= n) {
            int num = 0;
            for (int i = 0; i < list.size(); i++) {
                num = num*10 + list.get(i);
            }
            set.add(num);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (((mask & (1 << i)) != 0) || (i > 0 && nums[i] == nums[i-1] &&
            (mask & (1 << (i - 1))) == 0)) continue;
            list.add(nums[i]);
            backtrack(mask | (1 << i), n, list, set, nums);
            list.remove(list.size() - 1);
        }
    }
}