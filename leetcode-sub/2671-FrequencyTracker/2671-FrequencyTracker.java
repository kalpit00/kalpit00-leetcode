// Last updated: 7/23/2025, 1:27:46 PM
class FrequencyTracker {
    Map<Integer, Integer> map;
    Map<Integer, Set<Integer>> freqMap;
    public FrequencyTracker() {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(0, new HashSet<>());
    }
    
    public void add(int number) {
        int oldFreq = map.getOrDefault(number, 0);
        freqMap.get(oldFreq).remove(number);
        map.put(number, oldFreq + 1);
        freqMap.putIfAbsent(oldFreq + 1, new HashSet<>());
        freqMap.get(oldFreq + 1).add(number);
    }
    
    public void deleteOne(int number) {        
        if (map.containsKey(number)) {
            int oldFreq = map.get(number);
            freqMap.get(oldFreq).remove(number);
            map.put(number, oldFreq - 1);
            if (map.get(number) == 0) {
                map.remove(number);
            }
            else {
                freqMap.get(oldFreq - 1).add(number);
            }
        }
    }
    
    public boolean hasFrequency(int frequency) {
        return freqMap.containsKey(frequency) && 
        !freqMap.get(frequency).isEmpty();
    }
}