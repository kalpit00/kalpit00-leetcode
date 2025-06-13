// Last updated: 6/13/2025, 2:08:00 PM
class Solution {
    public int maximumProduct(int[] nums, int k) {
        int mod = 1000000007;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        long prod = 1;
        for (int i = 0; i < k; i++) {
            pq.offer(pq.poll() + 1);
        }
        while (!pq.isEmpty()) {
            prod = (prod % mod) * (pq.poll() % mod);
            prod %= mod;
        }
        return (int) (prod % mod);
    }
}