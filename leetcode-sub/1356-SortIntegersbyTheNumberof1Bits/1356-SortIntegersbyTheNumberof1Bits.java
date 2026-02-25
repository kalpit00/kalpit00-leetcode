// Last updated: 2/24/2026, 7:30:01 PM
1class Solution {
2    public int[] sortByBits(int[] arr) {
3        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.bitCount(a) != Integer.bitCount(b) ? Integer.bitCount(a) - Integer.bitCount(b) : a - b);
4        for (int num : arr) {
5            pq.offer(num);
6        }
7        int i = 0;
8        while (!pq.isEmpty()) {
9            arr[i++] = pq.poll();
10        }
11        return arr;
12    }
13}