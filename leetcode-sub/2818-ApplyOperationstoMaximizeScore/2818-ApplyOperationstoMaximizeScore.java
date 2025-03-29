// Last updated: 3/29/2025, 1:58:19 PM
class Solution {
    int mod = 1000000007;
    public int maximumScore(List<Integer> arr, int k) {
        int n = arr.size(), max = Integer.MIN_VALUE, idx = 0, top = -1;
        int[] nums = new int[n], NGE = new int[n], 
        PGE = new int[n], stack = new int[n];
        Arrays.fill(NGE, n);
        Arrays.fill(PGE, -1);
        for (int num : arr) {
            max = Math.max(max, num);
        }
        List<Integer> primes = sieve(max);
        for (int i = 0; i < n; i++) {
            int num = arr.get(i);
            for (int p : primes) {
                if (p * p > num) break; // Stop early if prime^2 exceeds num
                if (num % p != 0) continue; // Skip if prime is not a factor
                nums[i]++; // Increment prime score for the factor
                while (num % p == 0) {
                    num /= p; // Remove all occurrences of this factor
                } 
            }
            if (num > 1) {
                nums[i]++;
            } // If num is still greater than 1, it is a prime number itself
        }
        for (int i = 0; i < n; i++) {
            while (top != -1 && nums[stack[top]] < nums[i]) {
                int t = stack[top--];
                NGE[t] = i;
            }
            if (top != -1) {
                PGE[i] = stack[top];
            }
            stack[++top] = i;
        }
        long[] count = new long[n];
        long res = 1;
        for (int i = 0; i < n; i++) {
            count[i] = (long) (NGE[i] - i) * (i - PGE[i]);
        }
        int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = arr.get(i);
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, (a, b) -> b[0] - a[0]);
        while (k > 0) {
            int num = sorted[idx][0], i = sorted[idx++][1];
            long operations = Math.min(k, count[i]);
            res = (res * power(num, operations)) % mod;
            k -= operations;
        }
        return (int) res;
    }
    private long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b /= 2;
        }
        return res;
    }

    private List<Integer> sieve(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] notPrime = new boolean[n + 1];
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!notPrime[i]) {
            primes.add(i);
                for (int j = 2; i*j <= n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return primes;
    }
}