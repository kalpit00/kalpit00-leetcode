// Last updated: 10/9/2026, 3:18:50 AM
1class Solution {
2
3    public int minInsertions(String s) {
4        int insertions = 0;
5        int leftCount = 0;
6        int length = s.length();
7        int index = 0;
8        while (index < length) {
9            char c = s.charAt(index);
10            if (c == '(') {
11                leftCount++;
12                index++;
13            } else {
14                if (leftCount > 0) {
15                    leftCount--;
16                } else {
17                    insertions++;
18                }
19                if (index < length - 1 && s.charAt(index + 1) == ')') {
20                    index += 2;
21                } else {
22                    insertions++;
23                    index++;
24                }
25            }
26        }
27        insertions += leftCount * 2;
28        return insertions;
29    }
30}