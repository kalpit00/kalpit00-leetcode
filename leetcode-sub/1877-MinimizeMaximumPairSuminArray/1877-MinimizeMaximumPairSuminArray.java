// Last updated: 1/23/2026, 7:26:22 PM
1class Solution {
2    public int minPairSum(int[] nums) {
3        int maxSum = Integer.MIN_VALUE; // Variable to store the minimized maximum pair sum
4        int minNum = Integer.MAX_VALUE; // Variable to store the minimum number in the array
5        int maxNum = Integer.MIN_VALUE; // Variable to store the maximum number in the array
6
7        int frequency[] = new int[100001]; // Array to store the frequency of each number in the array
8
9        // Iterate through the array to populate frequency array and find min and max numbers
10        for (int num : nums) {
11            frequency[num]++;
12            minNum = Math.min(minNum, num);
13            maxNum = Math.max(maxNum, num);
14        }
15
16        // Initialize pointers for two numbers to form pairs
17        int low = minNum;
18        int high = maxNum;
19
20        // Iterate while low pointer is less than or equal to high pointer
21        while (low <= high) {
22            // If frequency of the number at low pointer is zero, move low pointer to the right
23            if (frequency[low] == 0) {
24                low++;
25            }
26            // If frequency of the number at high pointer is zero, move high pointer to the left
27            else if (frequency[high] == 0) {
28                high--;
29            }
30            // Both low and high pointers point to valid numbers
31            else {
32                // Calculate the sum of the pair at the current pointers
33                int currentPairSum = low + high;
34                // Update maxSum if the current pair sum is greater
35                maxSum = Math.max(maxSum, currentPairSum);
36                // Decrease the frequency of the numbers at low and high pointers
37                frequency[low]--;
38                frequency[high]--;
39            }
40        }
41
42        return maxSum; // Return the minimized maximum pair sum
43    }
44}