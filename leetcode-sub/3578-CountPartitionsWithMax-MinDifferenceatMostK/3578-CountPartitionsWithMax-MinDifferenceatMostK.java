// Last updated: 12/5/2025, 8:12:24 PM
1class Solution {
2    public int countPartitions(int[] nums, int k) {
3        int n = nums.length, left = 0, right = 0, count = 1, mod = 1000000007;
4        int[] dp = new int[n + 1];
5        dp[0] = 1;
6        Deque<Integer> maxDeque = new ArrayDeque<>();
7        Deque<Integer> minDeque = new ArrayDeque<>();   
8        while (right < n) {
9            while (!maxDeque.isEmpty() && 
10            nums[maxDeque.peekLast()] < nums[right]) {
11                maxDeque.pollLast();
12            }
13            while (!minDeque.isEmpty() &&
14            nums[minDeque.peekLast()] > nums[right]) {
15                minDeque.pollLast();
16            }
17            maxDeque.add(right);
18            minDeque.add(right);
19            right++;
20            while (!maxDeque.isEmpty() && !minDeque.isEmpty() && 
21            nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
22                if (maxDeque.peekFirst() == left) {
23                    maxDeque.pollFirst();
24                }
25                if (minDeque.peekFirst() == left) {
26                    minDeque.pollFirst();
27                }
28                count = (count - dp[left] + mod) % mod;
29                left++;
30            }
31            dp[right] = count;
32            count = (count + dp[right]) % mod;
33        }
34        return dp[n];
35    }
36}
37