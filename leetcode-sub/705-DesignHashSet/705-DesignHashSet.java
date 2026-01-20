// Last updated: 1/20/2026, 1:36:43 AM
1class MyHashSet {
2    private boolean[] set;
3    public MyHashSet() {
4        set = new boolean[1000001];
5    }
6    
7    public void add(int key) {
8        set[key] = true;
9    }
10    
11    public void remove(int key) {
12        set[key] = false;
13    }
14    
15    public boolean contains(int key) {
16        return set[key];
17    }
18}