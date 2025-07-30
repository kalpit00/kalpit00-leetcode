// Last updated: 7/30/2025, 1:41:37 AM
// String[] nums of equal length and consists of only digits.
//queries[k, trim] -> trim each number to rightmost trim digits and determine the kth smallest trimmed number.
/**
bruteforce: for each number store its index in the map.  TC: O(n), SC: O(n)
for each Query length q -> TC: O(q.n.l) and SC: O(n)
    trim the number by num[].length-trim O(l.n) where l is the length of the num
    sort the numbers by stable sorting algo TC: O(n.l), SC: O(n)
    find the kth smallest Number O(1)
    check the postion of that number in the map O(1)


we may do it with quick sort but then it will be O(q.nlogn)
extra space = O(n) for Map
after triming and sorting we need to maintain the Index

will use redix sort and sort by 1s, 10s, 100s... and will maintain corresponding array of int of index in the original array. will store this and use it..

space complexity: n*l -> i will maintain l arrays of n numbers
time complexity = n*L -> redix with counting sort
 */

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int digits = nums[0].length();
        int n = nums.length;

        //create array of object to preserve the order
        Pair[] numPairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            numPairs[i] = new Pair(nums[i], i);
        }

        
        Pair[][] sortedPairs = new Pair[digits][n];
        for (int exp = digits-1; exp >= 0; exp--) {
            numPairs = countingSort(numPairs, exp);  
            sortedPairs[exp] = numPairs;
        }

        int[] solutions = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            var trim = digits-queries[i][1];
            var k = queries[i][0]-1;
            solutions[i] = sortedPairs[trim][k].index;
        }
        return solutions;
    }

    private static Pair[] countingSort(Pair[] nums, int exp) {
        int[] count = new int[10];
        //count
        for(int i = 0; i < nums.length; i++) {
            int index = nums[i].num.charAt(exp) - '0';
            count[index]++;
        }

        //calculate cumulative count
        for(int i = 1; i < 10; i++) {
            count[i] = count[i]+count[i-1];
        }

        Pair[] sorted = new Pair[nums.length];
        //sort as per exp digit
        for(int i = nums.length - 1; i >= 0; i--) {
            int index = nums[i].num.charAt(exp) - '0';
            int finalIndex = count[index]-1;
            sorted[finalIndex] = nums[i];
            count[index]--;
        }
        return sorted;
    }

    record Pair(String num, int index){}
}