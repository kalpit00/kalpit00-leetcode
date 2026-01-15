// Last updated: 1/14/2026, 9:15:28 PM
1class Solution {
2    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
3        List<Double> angles = new ArrayList<>();
4        int count = 0;
5        for (List<Integer> p : points) {
6            int dx = p.get(0) - location.get(0);
7            int dy = p.get(1) - location.get(1);
8            if (dx == 0 && dy == 0) {
9                count++;
10                continue;
11            } 
12            angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
13        }
14        Collections.sort(angles);
15        List<Double> nums = new ArrayList<>(angles);
16        for (double d : angles) {
17            nums.add(d + 360); // concatenate to handle edge case
18        }
19        int n = nums.size(), max = 0, left = 0, right = 0;
20        while (right < n) {
21            while (nums.get(right) - nums.get(left) > angle) {
22                left++;
23            }
24            right++;
25            max = Math.max(max, right - left);
26        }
27        return max + count;
28    }
29}