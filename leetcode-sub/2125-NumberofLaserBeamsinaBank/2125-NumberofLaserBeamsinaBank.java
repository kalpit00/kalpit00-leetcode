// Last updated: 10/26/2025, 8:19:39 PM
class Solution {
    public int numberOfBeams(String[] bank) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (String s : bank) {
            int count = 0;
            for (char ch : s.toCharArray()) {
                count += ch == '1' ? 1 : 0;
            }
            if (count != 0) {
                list.add(count);
            }
        }
        for (int i = 1; i < list.size(); i++) {
            sum += list.get(i) * list.get(i - 1);
        }
        return sum;
    }
}