// Last updated: 7/19/2025, 9:54:17 PM
class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Trie trie = new Trie();
        for (List<String> path : paths) {
            Trie curr = trie;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new Trie(folder));
                curr = curr.children.get(folder);
            }
        }
        Map<String, Integer> keyMap = new HashMap<>();
        assignKeys(trie, keyMap);
        deleteDuplicates(trie, keyMap);
        List<List<String>> res = new ArrayList<>();
        dfs(trie, new ArrayList<>(), res);
        return res;
    }

    private String assignKeys(Trie node, Map<String, Integer> keyMap) {
        if (node.children.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
            Trie child = entry.getValue();
            sb.append(entry.getKey()).append("/").append(assignKeys(child, keyMap));
        }
        node.key = sb.append("&").toString();
        keyMap.put(node.key, keyMap.getOrDefault(node.key, 0) + 1);
        return node.key;
    }

    private void deleteDuplicates(Trie node, Map<String, Integer> keyMap) {
        List<String> toRemove = new ArrayList<>();
        for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
            Trie child = entry.getValue();
            deleteDuplicates(child, keyMap);
            if (keyMap.getOrDefault(child.key, 0) > 1) {
                toRemove.add(entry.getKey());
            }
        }
        for (String key : toRemove) {
            node.children.remove(key);
        }
    }

    private void dfs(Trie node, List<String> path, List<List<String>> res) {
        for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
            path.add(entry.getKey());
            res.add(new ArrayList<>(path));
            dfs(entry.getValue(), path, res);
            path.remove(path.size() - 1);
        }
    }

    class Trie {
        String name;
        String key;
        Map<String, Trie> children = new TreeMap<>();
        public Trie() {

        }
        public Trie(String name) {
            this.name = name;
        }
    }
}
