// Last updated: 8/31/2026, 2:58:28 AM
1class Solution {
2    public int[] nodesBetweenCriticalPoints(ListNode head) {
3        ListNode curr = head.next, prev = head;
4        int idx = 1, prevCriticalIndex = -1, firstCriticalIndex = -1;
5        int[] res = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
6        while (curr.next != null) {
7            if (isCriticalPoint(prev.val, curr.val, curr.next.val)) {
8                res[0] = prevCriticalIndex > 0 ? Math.min(res[0], idx - prevCriticalIndex) : res[0];
9                firstCriticalIndex = firstCriticalIndex == -1 ? idx : firstCriticalIndex;
10                prevCriticalIndex = idx;
11            }
12            prev = curr;
13            curr = curr.next;
14            idx++;
15        }
16        res[1] = prevCriticalIndex - firstCriticalIndex;
17        return prevCriticalIndex == firstCriticalIndex ? new int[]{-1, -1} : res;
18    }
19    private boolean isCriticalPoint(int left, int mid, int right) {
20        return (mid > left && mid > right) || (mid < left && mid < right);
21    }
22}