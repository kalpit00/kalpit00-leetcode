// Last updated: 6/14/2025, 11:58:11 PM
class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int n = digits.length, sum = 0, count = 0;
        reverseSort(digits);
        Map<String, Integer> dp = new HashMap<>();
        if (digits[0] == 0) {
            return "0";
        }
        int ans = solve(0, n, 0, digits, dp);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String key1 = (i + 1) + "," + (sum % 3);
            String key2 = (i + 1) + "," + ((sum + digits[i]) % 3);
            int val1 = dp.getOrDefault(key1, Integer.MIN_VALUE);
            int val2 = dp.getOrDefault(key2, Integer.MIN_VALUE);
            if (val1 > 1 + val2) {
                continue;
            } else {
                sb.append((char)('0' + digits[i]));
                sum += digits[i];
                sum %= 3;
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                count++;
            }
        }
        if (sb.length() == count && sb.length() > 0) {
            return "0";
        }
        return sb.toString();
    }
    
    private int solve(int i, int n, int sum, int[] digits, 
    Map<String, Integer> dp) {
        if (i == n) {
            if (sum == 0) {
                String key = i + "," + sum;
                dp.put(key, 0);
                return 0;
            }
            String key = i + "," + sum;
            dp.put(key, Integer.MIN_VALUE);
            return Integer.MIN_VALUE;
        }
        String key = i + "," + sum;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int take = 1 + solve(i + 1, n, (sum + digits[i]) % 3, digits, dp);
        int notTake = solve(i + 1, n, sum % 3, digits, dp);
        int max = Math.max(take, notTake);
        dp.put(key, max);
        return max;
    }
    private void reverseSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, i = 0, j = n - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}