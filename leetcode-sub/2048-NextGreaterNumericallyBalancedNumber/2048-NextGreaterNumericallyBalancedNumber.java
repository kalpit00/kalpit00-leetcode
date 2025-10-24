// Last updated: 10/23/2025, 8:33:33 PM
class Solution {
    public int nextBeautifulNumber(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(1224444);
        String[] map = {"1", "22", "122", "333", "1333", "4444", "14444",
        "22333", "55555", "122333", "155555", "224444", "666666"};
        for (String s : map) {
            int num = Integer.parseInt(s);
            char[] arr = s.toCharArray();
            while (!set.contains(num)) {
                set.add(num);
                nextPermutation(arr);
                num = Integer.parseInt(new String(arr));
            }
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
    public void nextPermutation(char[] nums) {
        int n = nums.length, i = n - 2, j = n - 1;
        for (i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i < 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        for (j = n - 1; j >= 0; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        swap(nums, i, j);
        reverse(nums, i + 1, n - 1);
    }

    private void reverse(char[] nums, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}