// Last updated: 8/9/2025, 12:43:58 AM
/**
Sort: nlgn
PQ: nlg3 -> n, space n
List: n, but also space 1
 */
class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int i = 0, j = 0, k = 0;
        int iV = 0, jV = 0, kV = 0;

        for (int idx = 0; idx < x.length; ++idx) {
            if (x[idx] == i) {
                iV = Math.max(iV, y[idx]);
            } else if (x[idx] == j) {
                jV = Math.max(jV, y[idx]);
            } else if (x[idx] == k) {
                kV = Math.max(kV, y[idx]);
            } else if (y[idx] > iV || y[idx] > jV || y[idx] > kV) {
                int min = Math.min(iV, Math.min(jV, kV));
                if (min == iV) {
                    iV = y[idx];
                    i = x[idx];
                } else if (min == jV) {
                    jV = y[idx];
                    j = x[idx];
                } else {
                    kV = y[idx];
                    k = x[idx];
                }
            }
        }

        return (iV==0 || jV==0 || kV==0) ? -1 : (iV+jV+kV);
    }

    // public int maxSumDistinctTriplet(int[] x, int[] y) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < x.length; ++i) {
    //         map.put(x[i], Math.max(map.getOrDefault(x[i], 0), y[i]));
    //     }
    //     if (map.size() < 3) {
    //         return -1;
    //     }

    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //     for (int value : map.values()) {
    //         minHeap.add(value);
    //         if (minHeap.size() > 3) {
    //             minHeap.poll();
    //         }
    //     }
        
    //     int sum = 0;
    //     while (!minHeap.isEmpty()) {
    //         sum += minHeap.poll();
    //     }
    //     return sum;
    // }
}