// Last updated: 7/19/2025, 12:27:58 PM
class Solution {
    public int[] secondGreaterElement(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                list.get(i).add(stack.pop());
            }
            stack.push(i);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < nums[i]) {
                res[pq.poll()[1]] = nums[i];
            }
            for (int j : list.get(i)) {
                pq.offer(new int[]{nums[j], j});
            }
        }
        return res;
    }
}