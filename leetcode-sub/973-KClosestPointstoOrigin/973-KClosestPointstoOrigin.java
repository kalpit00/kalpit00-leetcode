// Last updated: 8/1/2025, 1:42:47 AM
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        shuffle(points);
        int l = 0;
        int r = points.length - 1;
        int p = points.length;
        while(p != k){
            p = partition(points, l, r);

            if(p < k)
                l = p + 1;
            else if(p > k)
                r = p - 1;
        }

        return Arrays.copyOfRange(points, 0, k);
    }

    private void shuffle(int[][] points){
        Random rnd = new Random();
        for(int i = points.length - 1; i > 0; i--)
            swap(points, rnd.nextInt(i + 1), i);
    }

    private int partition(int[][] points, int l, int r){
        int i = l;
        for(int j = l; j < r; j++){
            if(euclidian(points[j]) <= euclidian(points[r]))
                swap(points, i++, j);
        }
        swap(points, i, r);
        return i;
    }

    private int euclidian(int[] p){
        return p[0] * p[0] + p[1] * p[1];
    }

    private void swap(int[][] points, int a, int b){
        int[] tmp = points[a];
        points[a] = points[b];
        points[b] = tmp;
    }
}