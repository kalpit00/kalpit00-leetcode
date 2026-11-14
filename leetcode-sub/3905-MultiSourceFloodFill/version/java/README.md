You are given two integers n and m representing the number of rows and columns of a grid, respectively.

You are also given a 2D integer array sources, where sources[i] = [ri, ci, color​​​​​​​i] indicates that the cell (ri, ci) is initially colored with colori. All other cells are initially uncolored and represented as 0.

At each time step, every currently colored cell spreads its color to all adjacent uncolored cells in the four directions: up, down, left, and right. All spreads happen simultaneously.

If multiple colors reach the same uncolored cell at the same time step, the cell takes the color with the maximum value.

The process continues until no more cells can be colored.

Return a 2D integer array representing the final state of the grid, where each cell contains its final color.

 
OriginalJavaExample 1:


Input: n = 3, m = 3, sources = [[0,0,1],[2,2,2]]

Output: [[1,1,2],[1,2,2],[2,2,2]]

Explanation:

The grid at each time step is as follows:

​​​​​​​

At time step 2, cells (0, 2), (1, 1), and (2, 0) are reached by both colors, so they are assigned color 2 as it has the maximum value among them.


Example 2:


Input: n = 3, m = 3, sources = [[0,1,3],[1,1,5]]

Output: [[3,3,3],[5,5,5],[5,5,5]]

Explanation:

The grid at each time step is as follows:




Example 3:


Input: n = 2, m = 2, sources = [[1,1,5]]

Output: [[5,5],[5,5]]

Explanation:

The grid at each time step is as follows:

​​​​​​​

Since there is only one source, all cells are assigned the same color.


 
Constraints:


	1 <= n, m <= 105
	1 <= n * m <= 105
	1 <= sources.length <= n * m
	sources[i] = [ri, ci, colori]
	0 <= ri <= n - 1
	0 <= ci <= m - 1
	1 <= colori <= 106​​​​​​​
	All (ri, ci​​​​​​​) in sources are distinct.

