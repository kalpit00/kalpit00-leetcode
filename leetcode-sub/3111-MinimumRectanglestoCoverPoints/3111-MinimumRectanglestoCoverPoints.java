// Last updated: 6/6/2025, 1:34:03 PM
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : cpdomains) {
            String[] s = word.split("\\s+");
            int freq = Integer.parseInt(s[0]);
            String[] domains = s[1].split("\\.");
            int n = domains.length;
            String key = "";
            for (int i = n - 1; i >= 0; i--) {
                key = domains[i] + (i < n - 1 ? "." : "") + key;
                map.put(key, map.getOrDefault(key, 0) + freq);
            }
        }
        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            int freq = map.get(key);
            res.add(freq + " " + key);
        }
        return res;
    }
}