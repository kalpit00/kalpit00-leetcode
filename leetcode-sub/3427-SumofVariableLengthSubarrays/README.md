You are given an integer array nums of size n. For each index i where 0 <= i < n, define a subarray nums[start ... i] where start = max(0, i - nums[i]).

Return the total sum of all elements from the subarray defined for each index in the array.

 
Example 1:


Input: nums = [2,3,1]

Output: 11

Explanation:

iSubarraySum0nums[0] = [2]21nums[0 ... 1] = [2, 3]52nums[1 ... 2] = [3, 1]4Total Sum 11

The total sum is 11. Hence, 11 is the output.


Example 2:


Input: nums = [3,1,1,2]

Output: 13

Explanation:

iSubarraySum0nums[0] = [3]31nums[0 ... 1] = [3, 1]42nums[1 ... 2] = [1, 1]23nums[1 ... 3] = [1, 1, 2]4Total Sum 13

The total sum is 13. Hence, 13 is the output.


 
Constraints:


	1 <= n == nums.length <= 100
	1 <= nums[i] <= 1000

