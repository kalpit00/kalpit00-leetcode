// Last updated: 6/3/2026, 11:39:23 PM
1class Solution {
2    public int totalWaviness(int num1, int num2) {
3        int sum = 0;
4        for (int i = num1; i <= num2; i++) {
5            sum += helper(i);
6        }
7        return sum;
8    }
9    private int helper(int num) {
10        List<Integer> list = new ArrayList<>();
11        while (num > 0) {
12            list.add(num % 10);
13            num /= 10;
14        }
15        int sum = 0;
16        for (int i = 1; i < list.size() - 1; i++) {
17            sum += (list.get(i) > list.get(i-1) && list.get(i) > list.get(i+1)) 
18            || (list.get(i) < list.get(i-1) && list.get(i) < list.get(i+1))
19            ? 1 : 0;
20        }
21        return sum;
22    }
23}