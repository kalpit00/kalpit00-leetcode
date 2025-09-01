// Last updated: 8/31/2025, 10:23:18 PM
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] r : classes) {
            int pass = r[0], total = r[1];
            pq.offer(new double[]{helper(pass, total), pass, total});
        }
        for (int i = 0; i < extraStudents; i++) {
            double[] r = pq.poll();
            double pass = r[1] + 1, total = r[2] + 1;
            pq.offer(new double[]{helper(pass, total), pass, total});
        }
        double sum = 0;
        while (!pq.isEmpty()) {
            double[] r = pq.poll();
            sum += r[1]/r[2];
        }
        return sum / n;
    }
    private double helper(double a, double b) {
        return (a + 1) / (b + 1) - a / b;
    }
}