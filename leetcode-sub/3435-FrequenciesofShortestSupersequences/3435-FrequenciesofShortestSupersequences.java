// Last updated: 8/8/2025, 5:09:38 PM
import java.util.*;

class Solution {
    public List<List<Integer>> supersequences(String[] words) {
        final int ALPHA = 26;
        boolean[] used = new boolean[ALPHA];
        for (String w : words) for (char c : w.toCharArray()) used[c - 'a'] = true;

        int[] charMap = new int[ALPHA];
        Arrays.fill(charMap, -1);
        List<Character> chars = new ArrayList<>();
        int charCount = 0;
        for (int c = 0; c < ALPHA; c++) {
            if (used[c]) {
                charMap[c] = charCount++;
                chars.add((char) ('a' + c));
            }
        }

        boolean[][] graph = new boolean[charCount][charCount];
        boolean[] selfLoop = new boolean[charCount];
        for (String w : words) {
            int u = charMap[w.charAt(0) - 'a'], v = charMap[w.charAt(1) - 'a'];
            if (u == v) selfLoop[u] = true;
            else graph[u][v] = true;
        }

        int[] disc = new int[charCount], low = new int[charCount], comp = new int[charCount];
        boolean[] inStack = new boolean[charCount];
        Arrays.fill(disc, -1);
        Arrays.fill(comp, -1);
        Deque<Integer> stk = new ArrayDeque<>();
        int[] time = {0}, sccTotal = {0};

        for (int i = 0; i < charCount; i++) if (disc[i] == -1) tarjan(i, graph, disc, low, comp, inStack, stk, time, sccTotal);

        List<List<Integer>> sccGroups = new ArrayList<>();
        for (int i = 0; i < sccTotal[0]; i++) sccGroups.add(new ArrayList<>());
        for (int i = 0; i < charCount; i++) sccGroups.get(comp[i]).add(i);

        List<List<Integer>> sccGraph = new ArrayList<>();
        for (int i = 0; i < sccTotal[0]; i++) sccGraph.add(new ArrayList<>());
        int[] inDegree = new int[sccTotal[0]];
        for (int u = 0; u < charCount; u++) {
            for (int v = 0; v < charCount; v++) {
                if (graph[u][v] && comp[u] != comp[v]) {
                    sccGraph.get(comp[u]).add(comp[v]);
                    inDegree[comp[v]]++;
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> topoOrder = new ArrayList<>();
        for (int i = 0; i < sccTotal[0]; i++) if (inDegree[i] == 0) q.offer(i);
        while (!q.isEmpty()) {
            int u = q.poll();
            topoOrder.add(u);
            for (int v : sccGraph.get(u)) if (--inDegree[v] == 0) q.offer(v);
        }

        List<List<List<Integer>>> sccPatterns = new ArrayList<>();
        for (int i = 0; i < sccTotal[0]; i++) {
            List<Integer> group = sccGroups.get(i);
            if (group.size() == 1) {
                if (selfLoop[group.get(0)]) sccPatterns.add(Collections.singletonList(Collections.singletonList(2)));
                else sccPatterns.add(Collections.singletonList(Collections.singletonList(1)));
                continue;
            }
            boolean[][] subgraph = new boolean[group.size()][group.size()];
            for (int j = 0; j < group.size(); j++) {
                if (selfLoop[group.get(j)]) subgraph[j][j] = true;
                for (int k = 0; k < group.size(); k++) {
                    if (graph[group.get(j)][group.get(k)]) subgraph[j][k] = true;
                }
            }
            sccPatterns.add(findMinFVS(subgraph, group.size()));
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int scc : topoOrder) {
            List<List<Integer>> newResult = new ArrayList<>();
            for (List<Integer> freq : result) {
                for (List<Integer> pattern : sccPatterns.get(scc)) {
                    List<Integer> newFreq = new ArrayList<>(freq);
                    while (newFreq.size() < charCount) newFreq.add(0);
                    List<Integer> group = sccGroups.get(scc);
                    for (int i = 0; i < group.size(); i++) newFreq.set(group.get(i), pattern.get(i));
                    newResult.add(newFreq);
                }
            }
            result = newResult;
        }

        Set<List<Integer>> uniqueFreqs = new HashSet<>();
        for (List<Integer> freq : result) {
            List<Integer> finalFreq = new ArrayList<>(Collections.nCopies(ALPHA, 0));
            for (int i = 0; i < charCount; i++) finalFreq.set(chars.get(i) - 'a', freq.get(i));
            uniqueFreqs.add(finalFreq);
        }

        return new ArrayList<>(uniqueFreqs);
    }

    private void tarjan(int u, boolean[][] graph, int[] disc, int[] low, int[] comp, boolean[] inStack,
                        Deque<Integer> stk, int[] time, int[] sccTotal) {
        disc[u] = low[u] = time[0]++;
        stk.push(u);
        inStack[u] = true;
        for (int v = 0; v < graph.length; v++) {
            if (!graph[u][v]) continue;
            if (disc[v] == -1) {
                tarjan(v, graph, disc, low, comp, inStack, stk, time, sccTotal);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if (low[u] == disc[u]) {
            while (true) {
                int v = stk.pop();
                inStack[v] = false;
                comp[v] = sccTotal[0];
                if (v == u) break;
            }
            sccTotal[0]++;
        }
    }

    private boolean isAcyclic(boolean[][] g, int mask, int n) {
        boolean[] removed = new boolean[n];
        for (int i = 0; i < n; i++) if ((mask & (1 << i)) != 0) removed[i] = true;

        int[] deg = new int[n];
        for (int u = 0; u < n; u++) {
            if (removed[u]) continue;
            for (int v = 0; v < n; v++) if (!removed[v] && g[u][v]) deg[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0, total = n - Integer.bitCount(mask);
        for (int i = 0; i < n; i++) if (!removed[i] && deg[i] == 0) q.offer(i);

        while (!q.isEmpty()) {
            int u = q.poll();
            cnt++;
            for (int v = 0; v < n; v++) if (!removed[v] && g[u][v] && --deg[v] == 0) q.offer(v);
        }
        return cnt == total;
    }

    private List<List<Integer>> findMinFVS(boolean[][] g, int n) {
        Set<List<Integer>> patterns = new HashSet<>();
        for (int sz = 0; sz <= n; sz++) {
            boolean found = false;
            for (int mask = 0; mask < (1 << n); mask++) {
                if (Integer.bitCount(mask) != sz) continue;
                if (isAcyclic(g, mask, n)) {
                    List<Integer> freq = new ArrayList<>(Collections.nCopies(n, 1));
                    for (int i = 0; i < n; i++) if ((mask & (1 << i)) != 0) freq.set(i, 2);
                    patterns.add(freq);
                    found = true;
                }
            }
            if (found) break;
        }
        return new ArrayList<>(patterns);
    }
}
