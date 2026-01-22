// Last updated: 1/21/2026, 11:46:12 PM
1class Solution {
2    public int minimumPairRemoval(int[] nums) {
3        List<Integer> list = new LinkedList<>();
4        for (int x : nums) {
5            list.add(x);
6        }
7        int count = 0;
8        while (!isSorted(list)) {
9            int min = Integer.MAX_VALUE, idx = 0;
10            for (int i = 0; i < list.size() - 1; i++) {
11                int sum = list.get(i) + list.get(i + 1);
12                if (sum < min) {
13                    min = sum;
14                    idx = i;
15                }
16            }
17            list.set(idx, min);
18            list.remove(idx + 1);
19            count++;
20        }
21        return count;
22    }
23
24    private boolean isSorted(List<Integer> list) {
25        for (int i = 1; i < list.size(); i++) {
26            if (list.get(i) < list.get(i - 1)) return false;
27        }
28        return true;
29    }
30}