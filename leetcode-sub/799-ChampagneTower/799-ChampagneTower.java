// Last updated: 4/28/2025, 2:32:33 PM
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<Double> prev = new ArrayList<>();
        prev.add((double) poured); // 1st top row has 1 element : n (poured)
        for (int i = 1; i <= query_row; i++) { // for rows = 1 to m
            List<Double> curr = new ArrayList<>();
            double n = prev.get(0); // pascals triangle! n -> (n - 1)/2
            curr.add(Math.max(0.0, (n - 1) / 2)); // first column = (n - 1) / 2
            for (int j = 1; j < i; j++) { // for columns 1 to i - 1
 // take from above row 1 col left n1 = prev[j - 1] and same col n2 = prev[j]
                double n1 = prev.get(j - 1), n2 = prev.get(j);
                double mid = Math.max(0.0, (n1 - 1) / 2) + Math.max(0.0, (n2 - 1) / 2); // n1, n2 splits -> (n1 - 1)/2 as well, add the two = mid!
                curr.add(mid);
            } // first and last cols has same val in any row in pascal triangle
            curr.add(curr.get(0)); // add the 0th from "curr" row to last 
            prev = curr; // move prev to curr for next row
        } // finally, prev will land to the last mth row. just take the col
        return Math.min(1, prev.get(query_glass));
    }
}