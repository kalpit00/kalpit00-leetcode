// Last updated: 8/17/2026, 9:49:56 PM
1class FrontMiddleBackQueue {
2    List<Integer> list;
3    public FrontMiddleBackQueue() {
4        list = new ArrayList<>();
5    }
6    
7    public void pushFront(int val) {
8        list.add(0, val);
9    }
10    
11    public void pushMiddle(int val) {
12        list.add(list.size() / 2, val);
13    }
14    
15    public void pushBack(int val) {
16        list.add(val);
17    }
18    
19    public int popFront() {
20        if (list.isEmpty()) return -1;
21        return list.remove(0);
22    }
23    
24    public int popMiddle() {
25        if (list.isEmpty()) return -1;
26        int n = list.size();
27        return n % 2 == 1 ? list.remove(n / 2) : list.remove((n / 2) - 1);
28    }
29    
30    public int popBack() {
31        if (list.isEmpty()) return -1;
32        return list.remove(list.size() - 1);
33    }
34}