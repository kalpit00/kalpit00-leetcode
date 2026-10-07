// Last updated: 10/6/2026, 10:39:49 PM
1class Solution {
2
3  private Set<String> validExpressions = new HashSet<String>();
4
5  private void recurse(
6      String s,
7      int index,
8      int leftCount,
9      int rightCount,
10      int leftRem,
11      int rightRem,
12      StringBuilder expression) {
13
14    // If we reached the end of the string, just check if the resulting expression is
15    // valid or not and also if we have removed the total number of left and right
16    // parentheses that we should have removed.
17    if (index == s.length()) {
18      if (leftRem == 0 && rightRem == 0) {
19        this.validExpressions.add(expression.toString());
20      }
21
22    } else {
23      char character = s.charAt(index);
24      int length = expression.length();
25
26      // The discard case. Note that here we have our pruning condition.
27      // We don't recurse if the remaining count for that parenthesis is == 0.
28      if ((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0)) {
29        this.recurse(
30            s,
31            index + 1,
32            leftCount,
33            rightCount,
34            leftRem - (character == '(' ? 1 : 0),
35            rightRem - (character == ')' ? 1 : 0),
36            expression);
37      }
38
39      expression.append(character);
40
41      // Simply recurse one step further if the current character is not a parenthesis.
42      if (character != '(' && character != ')') {
43
44        this.recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);
45
46      } else if (character == '(') {
47
48        // Consider an opening bracket.
49        this.recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);
50
51      } else if (rightCount < leftCount) {
52
53        // Consider a closing bracket.
54        this.recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
55      }
56
57      // Delete for backtracking.
58      expression.deleteCharAt(length);
59    }
60  }
61
62  public List<String> removeInvalidParentheses(String s) {
63
64    int left = 0, right = 0;
65
66    // First, we find out the number of misplaced left and right parentheses.
67    for (int i = 0; i < s.length(); i++) {
68
69      // Simply record the left one.
70      if (s.charAt(i) == '(') {
71        left++;
72      } else if (s.charAt(i) == ')') {
73        // If we don't have a matching left, then this is a misplaced right, record it.
74        right = left == 0 ? right + 1 : right;
75
76        // Decrement count of left parentheses because we have found a right
77        // which CAN be a matching one for a left.
78        left = left > 0 ? left - 1 : left;
79      }
80    }
81
82    this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
83    return new ArrayList<String>(this.validExpressions);
84  }
85}