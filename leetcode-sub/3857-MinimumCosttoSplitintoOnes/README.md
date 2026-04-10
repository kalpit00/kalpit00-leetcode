You are given an integer n.

In one operation, you may split an integer x into two positive integers a and b such that a + b = x.

The cost of this operation is a * b.

Return an integer denoting the minimum total cost required to split the integer n into n ones.

 
Example 1:


Input: n = 3

Output: 3

Explanation:

One optimal set of operations is:

xaba + ba * bCost312322211211

Thus, the minimum total cost is 2 + 1 = 3.


Example 2:


Input: n = 4

Output: 6

Explanation:


One optimal set of operations is:

xaba + ba * bCost422444211211211211

Thus, the minimum total cost is 4 + 1 + 1 = 6.



 
Constraints:


	1 <= n <= 500

