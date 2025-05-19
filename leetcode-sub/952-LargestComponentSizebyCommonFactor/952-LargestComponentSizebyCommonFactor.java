// Last updated: 5/19/2025, 7:22:39 PM
class Solution {
    public int largestComponentSize(int[] nums) {
        int n = nums.length, size = 0, max = 0;
        for (int num : nums) {
            size = Math.max(size, num);
        }
        int[] map = new int[size + 1];
        Arrays.fill(map, -1);
        List<Integer> primes = sieve(size + 1);;
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) {
            map[nums[i]] = i;
        }
        for (int i : primes) {
            int idx = -1;
            for (int j = 1; i * j <= size; j++) {
                if (map[i * j] == -1) continue;
                idx = idx == -1 ? map[i * j] : idx;
                dsu.union(idx, map[i * j]);
            }
        }  
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dsu.size[dsu.findParent(i)]);
        } // or also dsu.max will work, it maxes each size[pu, pv] when unioning
        return max; // but for NO unions, we have to take max of all size[]
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
            max = 0;
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
