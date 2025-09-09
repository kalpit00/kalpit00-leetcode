// Last updated: 9/8/2025, 8:54:48 PM
class Solution {
       public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] peopleWhoFoundSecretOnDay = new long[n + 1];
        peopleWhoFoundSecretOnDay[1] = 1; // given
        long peopleSharingSecrets = 0;
        long MOD = (long) (1e9 + 7);
        int time = 2;
        while (time <= n) {
            if (time - delay > 0) {
                peopleSharingSecrets = (peopleSharingSecrets + peopleWhoFoundSecretOnDay[time - delay] + MOD) % MOD;
            }
            if (time - forget > 0) {
                peopleSharingSecrets = (peopleSharingSecrets - peopleWhoFoundSecretOnDay[time - forget] + MOD) % MOD;
            }
            peopleWhoFoundSecretOnDay[time] = peopleSharingSecrets;
            ++time;
        }

        long peopleWhoKnow = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            peopleWhoKnow = (peopleWhoKnow + peopleWhoFoundSecretOnDay[i]) % MOD;
        }
        return (int) (peopleWhoKnow % MOD);
    }
}