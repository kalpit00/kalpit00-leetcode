// Last updated: 8/5/2025, 9:26:59 PM
class Skiplist {
    static class Node {
        int val;
        Node[] next;
        Node(int val, int level) {
            this.val = val;
            this.next = new Node[level + 1];
        }
    }

    private static final int MAX_LEVEL = 16;
    private static final double P = 0.5;
    private Node head;
    private int level;

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL); // sentinel head
        level = 0;
    }

    private int randomLevel() {
        int lvl = 0;
        while (Math.random() < P && lvl < MAX_LEVEL) lvl++;
        return lvl;
    }

    public boolean search(int target) {
        Node cur = head;
        for (int i = level; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < target)
                cur = cur.next[i];
        }
        cur = cur.next[0];
        return cur != null && cur.val == target;
    }

    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node cur = head;
        for (int i = level; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < num)
                cur = cur.next[i];
            update[i] = cur;
        }

        int lvl = randomLevel();
        if (lvl > level) {
            for (int i = level + 1; i <= lvl; i++) update[i] = head;
            level = lvl;
        }

        Node node = new Node(num, lvl);
        for (int i = 0; i <= lvl; i++) {
            node.next[i] = update[i].next[i];
            update[i].next[i] = node;
        }
    }

    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node cur = head;
        for (int i = level; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < num)
                cur = cur.next[i];
            update[i] = cur;
        }

        cur = cur.next[0];
        if (cur == null || cur.val != num) return false;

        for (int i = 0; i <= level; i++) {
            if (update[i].next[i] != cur) break;
            update[i].next[i] = cur.next[i];
        }

        while (level > 0 && head.next[level] == null) level--; // adjust top level
        return true;
    }
}
