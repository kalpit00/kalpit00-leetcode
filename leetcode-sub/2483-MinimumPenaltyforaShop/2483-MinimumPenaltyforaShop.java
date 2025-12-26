// Last updated: 12/26/2025, 5:01:08 AM
1class Solution {
2    public int bestClosingTime(String customers) {
3        int curPenalty = 0;
4        for (int i = 0; i < customers.length(); i++) {
5            if (customers.charAt(i) == 'Y') {
6                curPenalty++;
7            }
8        }
9
10        // Start with closing at hour 0, the penalty equals all 'Y' in closed hours.
11        int minPenalty = curPenalty;
12        int earliestHour = 0;
13
14        for (int i = 0; i < customers.length(); i++) {
15            char ch = customers.charAt(i);
16            
17            // If status in hour i is 'Y', moving it to open hours decrement
18            // penalty by 1. Otherwise, moving 'N' to open hours increment
19            // penatly by 1.
20            if (ch == 'Y') {
21                curPenalty--;
22            } else {
23                curPenalty++;
24            }
25
26            // Update earliestHour if a smaller penatly is encountered.
27            if (curPenalty < minPenalty) {
28                earliestHour = i + 1;
29                minPenalty = curPenalty;
30            }
31        }
32
33        return earliestHour;
34    }
35}