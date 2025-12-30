// Last updated: 12/30/2025, 8:03:28 AM
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int[] freq = new int[51];
        int ans = 0, cnt = 0;
        for(int n : nums){
            freq[n] = Math.max(freq[n], cnt) + 1;
            if(n == k){
                ans++;
                cnt++;
            }
            ans = Math.max(ans, freq[n]);
        }
        return ans;

        /*
        int orig = 0, ans = 0;
        for(int n : nums)
            if(n == k) 
                orig++;
        for(int i = 1; i <= 50; i++){
            if(i == k)
                continue;
            int cnt = 0, mx = 0;
            for(int n : nums){
                cnt += (n == i)? 1: (n == k)? -1: 0;
                cnt = Math.max(cnt, 0);
                mx = Math.max(mx, cnt);
            }
            ans = Math.max(ans, mx);
        }
        return orig + ans;
        */
    }
}