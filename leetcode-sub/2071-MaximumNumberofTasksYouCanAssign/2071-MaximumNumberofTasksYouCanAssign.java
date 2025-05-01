// Last updated: 4/30/2025, 8:16:15 PM
class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills,
    int strength) {
        int n = tasks.length, m = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int start = 1, end = Math.min(m, n), ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (helper(tasks, workers, pills, strength, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
    private boolean helper(int[] tasks, int[] workers, int pills, 
    int strength,int mid) {
        int m = workers.length, j = m - 1;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = mid - 1; i >= 0; --i) {
            while (j >= m - mid && workers[j] + strength >= tasks[i]) {
                dq.addFirst(workers[j--]);
            }
            if (dq.isEmpty()) {
                return false;
            } // strongest worker w/o pill
            else if (dq.peekLast() >= tasks[i]) {
                dq.pollLast();
            } 
            else { // weakest worker that can do w/ pill
                if (pills == 0) {
                    return false;
                }
                pills--;
                dq.pollFirst();
            }
        }
        return true;
    }
}