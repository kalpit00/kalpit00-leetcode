// Last updated: 5/19/2025, 3:26:53 PM
class Solution {
    public boolean gcdSort(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, n = nums.length;
        for (int num : nums) {
            set.add(num);
            max = Math.max(num, max);
        }
        List<Integer> primes = sieve(max + 1);
        DSU dsu = new DSU(max + 1);
        for (int i : primes) {
            for (int j = 2; i * j <= max; j++) {
                if (set.contains(i * j)) {
                    dsu.union(i, i * j);
                }
            }
        }
        int[] arr = nums.clone();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (dsu.findParent(nums[i]) != dsu.findParent(arr[i])) {
                return false;
            }
        }
        return true;
    }
    public List<Integer> sieve(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] notPrime = new boolean[n];
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                primes.add(i);
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return primes;
    }
    public class DSU {
        int[] parent;
        int[] size;
        public DSU (int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int findParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }
        public void union(int u, int v) {
            int pu = findParent(u), pv = findParent(v);
            if (pu == pv) {
                return;
            }
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            }
            else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }
}