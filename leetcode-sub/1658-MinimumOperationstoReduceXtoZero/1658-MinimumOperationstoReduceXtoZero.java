// Last updated: 2/19/2026, 7:16:09 PM
1class Solution {
2    /* 
3       This question is the equivalent of asking: What's the length of the longest subarray that adds up to the total sum
4       of all elements in the array, minus x? Let's say this subarray adds up to the variable target.
5       
6       Once we've got the answer to that question in a variable res, we can answer the original question by 
7       subtracting the resulting length from the total length of the array, since that's the number of 
8       operations we'd need to perform to produce the subarray, or nums.length - res.
9    */
10    public int minOperations(int[] nums, int x) {
11        int target = -x;
12        for (int num : nums) target += num; // These two steps are just setting our target = totalSum - x
13
14        /* If your totalSum = x, the longest subarray that adds up to x is the entire array. */
15        if (target == 0) return nums.length;
16        
17        
18        
19        /* 
20            The following map stores a map from a prefix sum to the index where it occurs. It answers the
21            question: How many elements in a row from the left side do I need to grab to get a sum adding up to k? If I call
22            map.get(k), I will get the answer.
23        */
24        Map<Integer, Integer> map = new HashMap<>();
25        map.put(0, -1); // We set this to -1 because it is a special case, and I will address it later.
26        
27        int res = Integer.MIN_VALUE; // This will store the length of the longest subarray
28        
29        /* 
30            Now, we're going to step through the array from left to right, using an index i, and adding to a sum.
31            We're trying to find the longest subarray that adds up to our target value.
32           
33            On each step i, the current sum is the equivalent of considering a range of elements where
34            all elements to the right of i have been excluded from our current subarray. To think back to our 
35            original problem, it's like performing nums.length - i operations on the right side.
36        */
37        int sum = 0;
38        for (int i = 0; i < nums.length; ++i) {
39
40            sum += nums[i];
41            
42            /*
43                At this point, we've excluded nums.length - i from the right side, and the sum of all 
44                elements to the left of and including i is stored in the sum variable. I'd like to know
45                if I can exclude some number of elements from the left side of my current subarray
46                so that my subarray sum is equal to target. Since we store prefix sums in the map,
47                I'd like to know if there's a nice prefix I can use that will help me accomplish this.
48                
49                Mathematically, nice_prefix + target = sum, so I want to check if the map contains
50                nice_prefix = target - sum .
51            
52            */
53            if (map.containsKey(sum - target)) {
54                
55                /* 
56                    So, I've found the nice prefix I need from the prefix map. Let's say that the nice prefix
57                    mapped to an index a. Now, I have a subarray in the middle of the array that adds up to target,
58                    where the first a elements and the last nums.length - i elements are excluded.
59                    What's the length of my current subarray? It's i - a.
60                    
61                    I need to check if this resulting length i - a is better than what I've previously found.
62                    
63                    What happens if sum = target? In that case, we don't need to exclude any elements
64                    from the left side. What's the length of my subarray in this case? It's i + 1, since our
65                    arrays are zero-indexed. Thus, in my map, I need to store - 1 so that the subtraction i - a
66                    evaluates to i + 1. This is why we made a map.put(0, -1) call earlier.
67    
68                */
69                res = Math.max(res, i - map.get(sum - target));
70            }
71
72            /* 
73                It looks like we couldn't find the prefix we needed, so let's store the current sum
74                (which is a prefix of elements up to index i) in the map. Since all numbers in the array
75                are positive, the sum will always increase with every step of the loop, so we don't 
76                have to worry about uniqueness.
77            */
78            map.put(sum, i);
79        }
80
81        /* 
82            Now, we've found the length of the longest subarray that adds up to target, and stored in res.
83            We need to answer our original question, which was the number of operations applied to both
84            sides to reach x. To get this value, we return nums.length - res.
85            
86            If we didn't find a subarray that added up to target, our result value should still be its
87            initial value, Integer.MIN_VALUE. In that case, no number of operations on either side
88            will allow us to reduce x to 0.
89        */
90        
91        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
92    }
93}