// Last updated: 4/23/2025, 3:44:33 PM
/* Copyright (c) 2024 by https://leetcode.com/brinuke/. All rights reserved. */
class Solution {
	public static int[] minDifference(int[] nums, int[][] queries) {
		int n = nums.length;
		int m = 0;
		for (int x : nums)
			if (x > m)
				m = x;
		int[][] count = new int[n + 1][]; // [end][value - 1]
		int[] c = count[0] = new int[m];
		for (int i = 0; i < n;) {
			c = c.clone();
			c[nums[i] - 1]++;
			count[++i] = c;
		}
		int k = queries.length;
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			int[] query = queries[i];
			int[] cb = count[query[0]];
			int[] ce = count[query[1] + 1];
			int prev = -m;
			int a = m;
			for (int x = 0; x < m; x++)
				if (cb[x] < ce[x]) {
					if (x - prev < a) {
						a = x - prev;
						if (a == 1)
							break;
					}
					prev = x;
				}
			ans[i] = a < m ? a : -1;
		}
		return ans;
	}
}