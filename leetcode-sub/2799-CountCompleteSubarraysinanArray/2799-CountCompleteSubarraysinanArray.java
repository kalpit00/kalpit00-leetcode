// Last updated: 4/17/2026, 9:03:05 PM
1public class Solution {
2    public int countCompleteSubarrays(int[] nums) {
3        int k = 0;
4        int[] map = new int[2002];
5        for (int num : nums) {
6            map[num]++;
7            k += map[num] == 1 ? 1 : 0;
8        }
9        return countCompleteSubarrays(nums, k) - 
10        countCompleteSubarrays(nums, k - 1);
11    }
12    public int countCompleteSubarrays(int[] nums, int k) {
13        int counter = 0, left = 0, right = 0, count = 0, n = nums.length;
14        int[] map = new int[2002];
15        while (right < n) {
16            map[nums[right]]++;
17            if (map[nums[right]] == 1) {
18                counter++;
19            }
20            right++;
21            while (counter > k) {
22                map[nums[left]]--;
23                if (map[nums[left]] == 0) {
24                    counter--;
25                }
26                left++;
27            }
28            count += (right - left);
29        }
30        return count;
31    }
32}
33