// Last updated: 4/27/2025, 12:06:56 PM
class AllOne {
    Map<String, Integer> freqMap;
    TreeMap<Integer, HashSet<String>> map;

    public AllOne() {
        freqMap = new HashMap<>();
        map = new TreeMap<>();
    }
    
    public void inc(String key) {
        int freq = freqMap.getOrDefault(key, 0);
        freqMap.put(key, freq + 1);
        if (freq > 0) {
            Set<String> set = map.get(freq);
            set.remove(key);
            if (set.isEmpty()) map.remove(freq);
        }
        map.putIfAbsent(freq + 1, new HashSet<>());
        map.get(freq + 1).add(key);
    }
    
    public void dec(String key) {
        if (!freqMap.containsKey(key)) return;
        int freq = freqMap.get(key);
        Set<String> set = map.get(freq);
        set.remove(key);
        if (set.isEmpty()) map.remove(freq);
        if (freq == 1) {
            freqMap.remove(key);
        } else {
            freqMap.put(key, freq - 1);
            map.putIfAbsent(freq - 1, new HashSet<>());
            map.get(freq - 1).add(key);
        }
    }
    
    public String getMaxKey() {
        return map.isEmpty() ? "" : 
        map.lastEntry().getValue().iterator().next();
    }
    
    public String getMinKey() {
        return map.isEmpty() ? "" : 
        map.firstEntry().getValue().iterator().next();
    }
}
