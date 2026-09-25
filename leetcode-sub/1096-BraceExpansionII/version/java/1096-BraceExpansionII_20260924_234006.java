// Last updated: 9/24/2026, 11:40:06 PM
1class Solution {
2
3    public List<String> braceExpansionII(String expression) {
4        Deque<Character> op = new ArrayDeque<Character>();
5        List<Set<String>> stk = new ArrayList<Set<String>>();
6
7        for (int i = 0; i < expression.length(); i++) {
8            if (expression.charAt(i) == ',') {
9                // Keep popping operators from the top of the stack until the stack is empty or its top is not a multiplication sign
10                while (!op.isEmpty() && op.peek() == '*') {
11                    ope(op, stk);
12                }
13                op.push('+');
14            } else if (expression.charAt(i) == '{') {
15                // First determine whether a multiplication sign needs to be added, then push { onto the operator stack
16                if (
17                    i > 0 &&
18                    (expression.charAt(i - 1) == '}' ||
19                        Character.isLetter(expression.charAt(i - 1)))
20                ) {
21                    op.push('*');
22                }
23                op.push('{');
24            } else if (expression.charAt(i) == '}') {
25                // Keep popping operators from the top of the stack until its top is {
26                while (!op.isEmpty() && op.peek() != '{') {
27                    ope(op, stk);
28                }
29                op.pop();
30            } else {
31                // First determine whether a multiplication sign needs to be added, then push the newly constructed set onto the set stack
32                if (
33                    i > 0 &&
34                    (expression.charAt(i - 1) == '}' ||
35                        Character.isLetter(expression.charAt(i - 1)))
36                ) {
37                    op.push('*');
38                }
39                StringBuilder sb = new StringBuilder();
40                sb.append(expression.charAt(i));
41                stk.add(
42                    new TreeSet<String>() {
43                        {
44                            add(sb.toString());
45                        }
46                    }
47                );
48            }
49        }
50
51        while (!op.isEmpty()) {
52            ope(op, stk);
53        }
54        return new ArrayList<String>(stk.get(stk.size() - 1));
55    }
56
57    // Pop the operator at the top of the stack and perform the calculation
58    public void ope(Deque<Character> op, List<Set<String>> stk) {
59        int l = stk.size() - 2,
60            r = stk.size() - 1;
61        if (op.peek() == '+') {
62            stk.get(l).addAll(stk.get(r));
63        } else {
64            Set<String> tmp = new TreeSet<String>();
65            for (String left : stk.get(l)) {
66                for (String right : stk.get(r)) {
67                    tmp.add(left + right);
68                }
69            }
70            stk.set(l, tmp);
71        }
72        op.pop();
73        stk.remove(stk.size() - 1);
74    }
75}