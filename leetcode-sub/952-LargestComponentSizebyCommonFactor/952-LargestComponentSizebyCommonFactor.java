// Last updated: 5/19/2025, 9:08:45 PM
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
        } // DSU on indices, not element vals
        for (int i : primes) {
            int firstIdx = -1; // get first multiple of prime 'i' in nums
            for (int j = 1; i * j <= size; j++) { // start j = 1, NOT 2
                if (map[i * j] == -1) {
                    continue; // if multiple (i * j) does not exist in nums[]
                } // use firstIdx as anchor, similar to groupAnagrams!
                firstIdx = firstIdx == -1 ? map[i * j] : firstIdx;
                dsu.union(firstIdx, map[i * j]);
            } // union the following multiple (i * j) to the 'first' multiple
        }  // and use indices to union, hence map, not i -> i*j
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
