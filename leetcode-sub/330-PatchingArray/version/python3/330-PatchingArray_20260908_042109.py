// Last updated: 9/8/2026, 4:21:09 AM
1class Solution:
2    def merge(self, intervals):
3        intervals.sort(key=lambda x: x[0])
4        merged = []
5        
6        for interval in intervals:
7            if not merged or merged[-1][1] < interval[0] - 1:
8                merged.append(interval)
9            else:
10                merged[-1][1] = max(merged[-1][1], interval[1])
11
12        return merged
13
14
15    def minPatches(self, nums, n):
16        ints, patches = [[0,0]], 0
17        for num in nums:
18            ints = self.merge(ints + [[i+num, j+num] for i,j in ints])
19
20        while ints[0][1] < n:
21            ints = self.merge(ints + [[i+ints[0][1]+1, j+ints[0][1]+1] for i,j in ints])
22            patches += 1
23
24        return patches