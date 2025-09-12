// Last updated: 9/12/2025, 12:03:06 AM
class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String>[] arr = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("electronics", 0);
        map.put("grocery", 1);
        map.put("pharmacy", 2);
        map.put("restaurant", 3);
        int n = code.length;
        for (int i = 0; i < n; i++) {
            if (!isActive[i] || !map.containsKey(businessLine[i]) || 
            !(code[i].matches("[a-zA-Z0-9_]+"))) continue;
            arr[map.get(businessLine[i])].add(code[i]);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Collections.sort(arr[i]);
            res.addAll(arr[i]);
        }
        return res;
    }
}