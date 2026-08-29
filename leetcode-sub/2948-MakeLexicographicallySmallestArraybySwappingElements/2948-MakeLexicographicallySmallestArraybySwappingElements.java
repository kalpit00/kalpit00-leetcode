// Last updated: 8/28/2026, 8:44:48 PM
1class Solution {
2
3    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
4        int[] numsSorted = new int[nums.length];
5        for (int i = 0; i < nums.length; i++) numsSorted[i] = nums[i];
6        Arrays.sort(numsSorted);
7
8        int currGroup = 0;
9        HashMap<Integer, Integer> numToGroup = new HashMap<>();
10        numToGroup.put(numsSorted[0], currGroup);
11
12        HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
13        groupToList.put(
14            currGroup,
15            new LinkedList<Integer>(Arrays.asList(numsSorted[0]))
16        );
17
18        for (int i = 1; i < nums.length; i++) {
19            if (Math.abs(numsSorted[i] - numsSorted[i - 1]) > limit) {
20                // new group
21                currGroup++;
22            }
23
24            // assign current element to group
25            numToGroup.put(numsSorted[i], currGroup);
26
27            // add element to sorted group list
28            if (!groupToList.containsKey(currGroup)) {
29                groupToList.put(currGroup, new LinkedList<Integer>());
30            }
31            groupToList.get(currGroup).add(numsSorted[i]);
32        }
33
34        // iterate through input and overwrite each element with the next element in its corresponding group
35        for (int i = 0; i < nums.length; i++) {
36            int num = nums[i];
37            int group = numToGroup.get(num);
38            nums[i] = groupToList.get(group).pop();
39        }
40
41        return nums;
42    }
43}