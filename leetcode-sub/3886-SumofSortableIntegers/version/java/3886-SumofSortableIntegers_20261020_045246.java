// Last updated: 10/20/2026, 4:52:46 AM
1class Solution {
2    public int sortableIntegers(int[] nums) {
3        int n = nums.length, ans = 0;
4        List<Integer> fac = new ArrayList<>();
5        for (int x = 1; x * x <= n; x++) {
6            if (n % x == 0) {
7                fac.add(x);
8                if (n / x != x) {
9                    fac.add(n / x);
10                }
11            }
12        }
13        int[] target = nums.clone();
14        Arrays.sort(target);
15        for (int d : fac) {
16            boolean allGood = true;
17            for (int left = 0; left < n; left += d) {
18                int right = left + d - 1;
19                int[] sub1 = Arrays.copyOfRange(nums, left, right + 1);
20                int[] sub2 = Arrays.copyOfRange(target, left, right + 1);
21                if (!check(sub1, sub2)) {
22                    allGood = false;
23                    break;
24                }
25            }
26            if (allGood) {
27                ans += d;
28            }
29        }
30
31        return ans;
32    }
33
34    private boolean check(int[] nums1, int[] nums2) {
35        // Check whether cyclic rotations of nums1 can produce nums2
36        int[] doubled = new int[nums1.length * 2];
37        System.arraycopy(nums1, 0, doubled, 0, nums1.length);
38        System.arraycopy(nums1, 0, doubled, nums1.length, nums1.length);
39
40        return kmp(doubled, nums2);
41    }
42
43    private boolean kmp(int[] text, int[] pattern) {
44        int n = text.length,
45            m = pattern.length;
46        int[] pi = new int[m];
47        int j = 0;
48
49        for (int i = 1; i < m; i++) {
50            while (j > 0 && pattern[i] != pattern[j]) {
51                j = pi[j - 1];
52            }
53            if (pattern[i] == pattern[j]) {
54                j++;
55            }
56            pi[i] = j;
57        }
58
59        j = 0;
60        for (int i = 0; i < n; i++) {
61            while (j > 0 && text[i] != pattern[j]) {
62                j = pi[j - 1];
63            }
64            if (text[i] == pattern[j]) {
65                j++;
66            }
67            if (j == m) {
68                return true;
69            }
70        }
71        return false;
72    }
73}