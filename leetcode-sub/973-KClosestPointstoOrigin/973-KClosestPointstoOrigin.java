// Last updated: 8/1/2025, 1:39:29 AM
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        Point[] nums = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1], val = x * x + y * y;
            nums[i] = new Point(x, y, val);
        }
        nums = quickSort(nums);
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = new int[]{nums[i].x, nums[i].y};
        }
        return res;
    }
    private Point[] quickSort(Point[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums;
        }
        int pivot = nums[new Random().nextInt(n)].val;
        int l = 0, r = 0, m = 0, k = 0, j = 0;
        for (int i = 0; i < n; i++) {
            k += nums[i].val == pivot ? 1 : 0;
            m += nums[i].val < pivot ? 1 : 0;
        }
        Point[] left = new Point[m], mid = new Point[k], 
        right = new Point[n - m - k];
        for (int i = 0; i < n; i++) {
            if (nums[i].val < pivot) {
                left[l++] = nums[i];
            } else if (nums[i].val == pivot) {
                mid[j++] = nums[i];
            } else {
                right[r++] = nums[i];
            }
        }
        left = quickSort(left);
        right = quickSort(right);        
        return merge(left, mid, right);
    }
    
    private Point[] merge(Point[] left, Point[] mid, Point[] right) {
        int m = left.length, j = mid.length, n = right.length, k = 0;
        Point[] res = new Point[m + j + n];
        for (int i = 0; i < m; i++) {
            res[k++] = left[i];
        }        
        for (int i = 0; i < j; i++) {
            res[k++] = mid[i];
        }        
        for (int i = 0; i < n; i++) {
            res[k++] = right[i];
        }
        return res;
    }
    class Point {
        int x, y, val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}