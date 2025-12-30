// Last updated: 12/29/2025, 11:21:27 PM
1class Solution {
2    public int countPairs(int[] nums, int low, int high) {
3        return countToLim(nums, high+1) - countToLim(nums, low);
4    }
5
6
7    private int countToLim(int[] nums, int lim) { //counts up to lim exclusive by counting all that match some prefix of binary limit but remove exactly one bit (so they are lesser)
8        int max = 0, n = nums.length;
9        for(int num : nums) max = Math.max(num, max);
10        /*gsb is greatest set bit, can early return if know that
11        the greatest allowed to be set to stay < lim
12        is greater than the max value in nums as this means
13        that no xor can ever make high enough bits to exceed limit and
14        thus all pairs are below them limit so return all (n choose 2)*/
15        int gsb = 31 - Integer.numberOfLeadingZeros(lim-1);
16        if(max < (1 << gsb)) return (n*(n-1))/2;
17        int lsb = (lim & -lim);
18        int[] cnt = new int[(1 << (32-Integer.numberOfLeadingZeros(max)))/lsb];
19        for(int num : nums) cnt[num/lsb]++;
20        int res = 0;
21        lim /= lsb;
22        while(--lim > 0) { //iterate prefix's of limit by their lsb
23            lsb = (lim & -lim);
24            int[] cnt2 = new int[cnt.length/lsb];
25            for(int mask = 0; mask < cnt.length; mask++) {
26                if(cnt[mask] == 0) continue;
27                if(lsb > 0) cnt2[mask/lsb] += cnt[mask];
28                res += cnt[mask]*cnt[lim ^ mask];
29            }
30            lim /= lsb;
31            cnt = cnt2;
32        }
33
34        for(int mask = 0; mask < cnt.length; mask++) res += cnt[mask]*(cnt[mask]-1);
35        return res/2;
36    }
37
38    
39}