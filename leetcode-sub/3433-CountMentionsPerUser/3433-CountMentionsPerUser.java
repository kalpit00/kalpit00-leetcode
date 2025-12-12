// Last updated: 12/12/2025, 12:20:07 AM
1class Solution {
2
3    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
4        events.sort((a, b) -> {
5            int timeA = Integer.parseInt(a.get(1));
6            int timeB = Integer.parseInt(b.get(1));
7            if (timeA != timeB) {
8                return Integer.compare(timeA, timeB);
9            }
10            boolean aIsMessage = a.get(0).equals("MESSAGE");
11            boolean bIsMessage = b.get(0).equals("MESSAGE");
12            return Boolean.compare(aIsMessage, bIsMessage);
13        });
14
15        int[] count = new int[numberOfUsers];
16        int[] nextOnlineTime = new int[numberOfUsers];
17
18        for (List<String> event : events) {
19            int curTime = Integer.parseInt(event.get(1));
20            String type = event.get(0);
21
22            if (type.equals("MESSAGE")) {
23                String target = event.get(2);
24                if (target.equals("ALL")) {
25                    for (int i = 0; i < numberOfUsers; i++) {
26                        count[i]++;
27                    }
28                } else if (target.equals("HERE")) {
29                    for (int i = 0; i < numberOfUsers; i++) {
30                        if (nextOnlineTime[i] <= curTime) {
31                            count[i]++;
32                        }
33                    }
34                } else {
35                    String[] users = target.split(" ");
36                    for (String user : users) {
37                        int idx = Integer.parseInt(user.substring(2));
38                        count[idx]++;
39                    }
40                }
41            } else {
42                int idx = Integer.parseInt(event.get(2));
43                nextOnlineTime[idx] = curTime + 60;
44            }
45        }
46
47        return count;
48    }
49}