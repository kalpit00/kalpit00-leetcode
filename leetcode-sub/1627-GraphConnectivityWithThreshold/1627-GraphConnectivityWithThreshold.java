// Last updated: 5/20/2025, 3:31:00 AM
class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        return largestComponentSize(nums) == n;
    }
    public int largestComponentSize(int[] nums) {
        int n = nums.length, size = 0, max = 0;
        for (int num : nums) {
            size = Math.max(size, num);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        List<Integer> primes = sieve(size + 1);;
        DSU dsu = new DSU(n);
        for (int i : primes) {
            int firstIdx = -1;
            for (int j = 1; i * j <= size; j++) {
                if (!map.containsKey(i * j)) {
                    continue;
                }
                for (int idx : map.get(i * j)) {
                    firstIdx = firstIdx == -1 ? idx : firstIdx;
                    dsu.union(firstIdx, idx);
                }
            } 
        }
        return dsu.max;
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

    class DSU {
        int[] size, parent;
        int componentCount, max;
        public DSU(int n) {
            size = new int[n];
            parent = new int[n];
            componentCount = n;
            max = 1;
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
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
            if (pu == pv) return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
            componentCount--;
            max = Math.max(max, Math.max(size[pu], size[pv]));
        }
    }
}
