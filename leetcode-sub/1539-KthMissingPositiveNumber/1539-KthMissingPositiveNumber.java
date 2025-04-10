// Last updated: 4/9/2025, 9:33:42 PM
class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int i = 1;
        while (k > 0) {
            if (!set.contains(i)) {
                k--;
            }
            i++;
        }
        return i - 1;
    }
}
