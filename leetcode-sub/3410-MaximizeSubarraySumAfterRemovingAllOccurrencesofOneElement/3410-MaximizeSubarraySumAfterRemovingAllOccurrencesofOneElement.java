// Last updated: 5/4/2025, 12:32:36 PM
import java.util.*;

class Node {
    long prefix, suffix, total, ans;

    Node(long prefix, long suffix, long total, long ans) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.total = total;
        this.ans = ans;
    }

    Node() {
        this.prefix = 0;
        this.suffix = 0;
        this.total = 0;
        this.ans = 0;
    }
}

class SegmentTreeMax {
    int n;
    int[] nums;
    Node[] tree;

    SegmentTreeMax(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.tree = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            tree[i] = new Node();
        }
        build(0, 0, n - 1);
    }

    private Node merge(Node left, Node right) {
        Node res = new Node();
        res.total = left.total + right.total;
        res.prefix = Math.max(left.prefix, left.total + right.prefix);
        res.suffix = Math.max(right.suffix, right.total + left.suffix);
        res.ans = Math.max(Math.max(left.ans, right.ans), left.suffix + right.prefix);
        return res;
    }

    private void build(int node, int s, int e) {
        if (s == e) {
            long value = nums[s];
            tree[node] = new Node(value, value, value, value);
            return;
        }

        int mid = (s + e) / 2;
        build(2 * node + 1, s, mid);
        build(2 * node + 2, mid + 1, e);
        tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public void update(int node, int s, int e, int idx, long value) {
        if (s == e) {
            tree[node] = new Node(value, value, value, value);
            return;
        }

        int mid = (s + e) / 2;
        if (idx <= mid) {
            update(2 * node + 1, s, mid, idx, value);
        } else {
            update(2 * node + 2, mid + 1, e, idx, value);
        }

        tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public Node query(int node, int s, int e, int qs, int qe) {
        if (qs <= s && e <= qe) {
            return tree[node];
        }

        if (qe < s || e < qs) {
            return new Node(Long.MIN_VALUE, Long.MIN_VALUE, 0, Long.MIN_VALUE);
        }

        int mid = (s + e) / 2;
        Node left = query(2 * node + 1, s, mid, qs, qe);
        Node right = query(2 * node + 2, mid + 1, e, qs, qe);
        return merge(left, right);
    }

    public long maxSubarraySum(int l, int r) {
        Node result = query(0, 0, n - 1, l, r);
        return result.ans;
    }
}

class Solution {
    public long maxSubarraySum(int[] nums) {
        int n = nums.length;
        long res = Long.MIN_VALUE;

        // Edge case for all negative numbers
        int maxNum = Arrays.stream(nums).max().getAsInt();
        if (maxNum < 0) {
            return maxNum;
        }

        SegmentTreeMax obj = new SegmentTreeMax(nums);
        Map<Integer, List<Integer>> d = new HashMap<>();
        for (int i = 0; i < n; i++) {
            d.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (int l : d.keySet()) {
            List<Integer> indices = d.get(l);
            for (int j : indices) {
                obj.update(0, 0, n - 1, j, 0);
            }

            res = Math.max(res, obj.maxSubarraySum(0, n - 1));

            for (int j : indices) {
                obj.update(0, 0, n - 1, j, l);
            }
        }

        res = Math.max(res, obj.maxSubarraySum(0, n - 1));
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, -2, 3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + sol.maxSubarraySum(nums));
    }
}
