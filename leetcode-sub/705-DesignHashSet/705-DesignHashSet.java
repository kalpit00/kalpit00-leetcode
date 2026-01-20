// Last updated: 1/20/2026, 1:40:08 AM
1class MyHashSet {
2    private boolean[] set;
3    public MyHashSet() {
4        set = new boolean[1000001];
5    }
6    public void add(int key) {
7        set[key] = true;
8    }
9    public void remove(int key) {
10        set[key] = false;
11    }
12    public boolean contains(int key) {
13        return set[key];
14    }
15}