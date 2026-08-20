// Last updated: 8/19/2026, 8:12:26 PM
1class Solution {
2
3    public int[] resultArray(int[] nums) {
4        int n = nums.length;
5        int[] arr = new int[n];
6        arr[0] = nums[0];
7        arr[n - 1] = nums[1];
8        int idx = 0,
9            revIdx = n - 1;
10        for (int i = 2; i < n; i++) {
11            if (arr[idx] > arr[revIdx]) {
12                arr[++idx] = nums[i];
13            } else {
14                arr[--revIdx] = nums[i];
15            }
16        }
17        for (int l = revIdx, r = n - 1; l < r; l++, r--) {
18            int tmp = arr[l];
19            arr[l] = arr[r];
20            arr[r] = tmp;
21        }
22        return arr;
23    }
24}