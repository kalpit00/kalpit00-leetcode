// Last updated: 8/1/2026, 12:49:54 AM
1class Solution {
2    public boolean predictTheWinner(int[] nums) {
3        int n = nums.length;
4        Integer[][][] memo = new Integer[n][n][3];
5        return minimax(nums, 1, 0, n - 1, memo) >= 0; // start with player 1
6    }
7    private int minimax(int[] nums, int player, int left, int right, 
8    Integer[][][] memo) {
9        if (left == right) { // BASE CASE, at the mid, last item to take.
10            return (player == 1 ? 1 : -1) * nums[left]; // p1 adds, p2 subtracts
11        } // can do nums[right] too, left is == right lol, its 2 ptr approach
12        if (memo[left][right][player] != null) {
13            return memo[left][right][player]; // memoization step
14        }
15        int res = 0; // player 1 maximizes, so add. player 2 minimizes, so subtr
16        if (player == 1) { // choose item at left end or right end, max option
17            res = Math.max( // next turn is p2, so pass 2
18                    nums[left] + minimax(nums, 2, left + 1, right, memo),
19                    nums[right] + minimax(nums, 2, left, right - 1, memo)
20            ); // pass left++ or right-- according to which one is chosen
21        } else {
22            res = Math.min( // next turn is p1, pass 1
23                    -nums[left] + minimax(nums, 1, left + 1, right, memo),
24                    -nums[right] + minimax(nums, 1, left, right - 1, memo)
25            ); // min and subtract the item as he is minimizer
26        }
27        memo[left][right][player] = res;
28        return res;
29    }
30}