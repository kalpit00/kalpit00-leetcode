You are climbing a staircase with n + 1 steps, numbered from 0 to n.

You are also given a 1-indexed integer array costs of length n, where costs[i] is the cost of step i.

From step i, you can jump only to step i + 1, i + 2, or i + 3. The cost of jumping from step i to step j is defined as: costs[j] + (j - i)2

You start from step 0 with cost = 0.

Return the minimum total cost to reach step n.

 
Example 1:


Input: n = 4, costs = [1,2,3,4]

Output: 13

Explanation:

One optimal path is 0 → 1 → 2 → 4

JumpCost CalculationCost0 → 1costs[1] + (1 - 0)2 = 1 + 121 → 2costs[2] + (2 - 1)2 = 2 + 132 → 4costs[4] + (4 - 2)2 = 4 + 48

Thus, the minimum total cost is 2 + 3 + 8 = 13


Example 2:


Input: n = 4, costs = [5,1,6,2]

Output: 11

Explanation:

One optimal path is 0 → 2 → 4

JumpCost CalculationCost0 → 2costs[2] + (2 - 0)2 = 1 + 452 → 4costs[4] + (4 - 2)2 = 2 + 46

Thus, the minimum total cost is 5 + 6 = 11


Example 3:


Input: n = 3, costs = [9,8,3]

Output: 12

Explanation:

The optimal path is 0 → 3 with total cost = costs[3] + (3 - 0)2 = 3 + 9 = 12


 
Constraints:


	1 <= n == costs.length <= 105​​​​​​​
	1 <= costs[i] <= 104

