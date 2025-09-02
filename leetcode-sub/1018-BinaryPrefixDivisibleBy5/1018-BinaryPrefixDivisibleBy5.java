// Last updated: 9/2/2025, 5:29:55 PM
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length, binaryNum = 0;
		List<Boolean> res = new ArrayList<>(); 
		for (int i = 0; i < n; i++) {
			binaryNum = (binaryNum * 2 + nums[i]) % 5;
			res.add(binaryNum == 0);
		}
		return res;
    }
}