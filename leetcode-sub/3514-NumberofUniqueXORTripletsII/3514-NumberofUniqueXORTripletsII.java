// Last updated: 7/23/2026, 8:02:51 PM
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int n = nums.length;
4        Set<Integer> pairs = new HashSet<>(List.of(0)); 
5        for (int i = 0; i < n; i++) {
6            for (int j = i + 1; j < n; j++) {
7                pairs.add(nums[i] ^ nums[j]);
8            }
9        }
10        BitSet triplets = new BitSet();
11        for (int xy : pairs) {
12            for (int z : nums) {
13                triplets.set(xy ^ z);
14            }
15        }
16        return triplets.cardinality();
17    }
18}