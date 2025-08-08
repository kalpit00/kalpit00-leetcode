// Last updated: 8/8/2025, 5:11:23 PM
class Solution {

    public static ArrayList<Integer> gr[];
    public List<List<Integer>> supersequences(String[] words) {
        HashMap<Character, Integer> hs = new HashMap<>();
        int id = 0;
        for (String x : words) {
            if (!hs.containsKey(x.charAt(0))) {
                hs.put(x.charAt(0), id);
                id++;
            }
            if (!hs.containsKey(x.charAt(1))) {
                hs.put(x.charAt(1), id);
                id++;
            }
        }
        int n = hs.size();
        char chars[] = new char[n];
        for (var x : hs.entrySet()) {
            chars[x.getValue()] = x.getKey();
        }
        gr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            gr[i] = new ArrayList<>();
        }
        for (String x : words) {
            int u = hs.get(x.charAt(0)), v = hs.get(x.charAt(1));
            gr[u].add(v);
        }
        List<List<Integer>> ans = new ArrayList<>();
        if (!cycle(n, 0)) {
            List<Integer> all = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                all.add(0);
            }
            for (int i = 0; i < n; i++) {
                all.set((chars[i] - 'a'), 1);
            }
            ans.add(all);
            return ans;
        }
        int len = Integer.MAX_VALUE;
        for (int i = 1; i < (1 << n); i++) {
            int tl = 0, tmp = i;
            while (tmp > 0) {
                tl += (tmp & 1);
                tmp = tmp >> 1;
            }
            if (tl > len)
                continue;
            if (!cycle(n, i)) {
                if (tl < len) {
                    len = tl;
                    ans = new ArrayList<>();
                }
                int fr[] = new int[26];
                for (int p = 0; p < n; p++) {
                    int index = chars[p] - 'a';
                    if ((i & (1 << p)) != 0) {
                        fr[index] = 2;
                    } else {
                        fr[index] = 1;
                    }
                }
                List<Integer> all = new ArrayList<>();
                for (int p = 0; p < 26; p++) {
                    all.add(fr[p]);
                }
                ans.add(all);
            }
        }
        return ans;

    }

    public static boolean vis[];

    public static boolean cycle(int n, int mask) {
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                continue;
            }
            vis = new boolean[n];
            if (helper(i, mask)) {
                return true;
            }
        }
        return false;
    }

    public static boolean helper(int curr, int mask) {
        vis[curr] = true;
        for (int i = 0; i < gr[curr].size(); i++) {
            int v = gr[curr].get(i);
            if ((mask & (1 << v)) != 0) {
                continue;
            }
            if (vis[v]) {
                return true;
            }
            if (helper(v, mask)) {
                return true;
            }
        }
        vis[curr] = false;
        return false;
    }
}