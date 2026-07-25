You are given an integer array nums.

For each element nums[i], you may perform the following operations any number of times (including zero):


	Increase nums[i] by 1, or
	Decrease nums[i] by 1.


A number is called a binary palindrome if its binary representation without leading zeros reads the same forward and backward.

Your task is to return an integer array ans, where ans[i] represents the minimum number of operations required to convert nums[i] into a binary palindrome.

 
Example 1:


Input: nums = [1,2,4]

Output: [0,1,1]

Explanation:

One optimal set of operations:

nums[i]Binary(nums[i])Nearest
			PalindromeBinary
			(Palindrome)Operations Requiredans[i]1111Already palindrome0210311Increase by 114100311Decrease by 11

Thus, ans = [0, 1, 1].


Example 2:


Input: nums = [6,7,12]

Output: [1,0,3]

Explanation:

One optimal set of operations:

nums[i]Binary(nums[i])Nearest
			PalindromeBinary
			(Palindrome)Operations Requiredans[i]61105101Decrease by 1171117111Already palindrome0121100151111Increase by 33

Thus, ans = [1, 0, 3].


 
Constraints:


	1 <= nums.length <= 5000
	​​​​​​​1 <= nums[i] <= 5000

