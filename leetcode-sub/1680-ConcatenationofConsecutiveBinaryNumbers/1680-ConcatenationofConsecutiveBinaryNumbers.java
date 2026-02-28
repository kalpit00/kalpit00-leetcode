// Last updated: 2/27/2026, 11:22:48 PM
class Solution {
    public int concatenatedBinary(int n) {
        int bi = 0;
        long res = 0;
        final long MOD = (long)(1e9 + 7);
        for(int i=1;i<=n;i++){
            if((i&(i-1)) == 0) bi++;
            res = ((res << bi)+i)%MOD;
        }
        return (int)res;
    }
}