// Last updated: 11/30/2025, 8:12:57 PM
1class Solution {
2    public long maxRunTime(int n, int[] batteries) {
3        long sumPower = 0;
4        for (int power : batteries)
5            sumPower += power;
6        long left = 1, right = sumPower / n;
7        
8        while (left < right){
9            long target = right - (right - left) / 2;
10            long extra = 0;
11            
12            for (int power : batteries)
13                extra += Math.min(power, target);
14
15            if (extra >= (long)(n * target))
16                left = target;
17            else
18                right = target - 1;
19        }
20        return left;
21    }
22}