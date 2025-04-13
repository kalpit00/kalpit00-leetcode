// Last updated: 4/13/2025, 2:30:47 PM
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();
        int n = transactions.length;
        String[] names = new String[n], cities = new String[n];
        int[] times = new int[n], amounts = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] items = transactions[i].split(",");
            String name = items[0], time = items[1], amount = items[2], city = items[3];
            names[i] = name;
            cities[i] = city;
            times[i] = Integer.parseInt(time);
            amounts[i] = Integer.parseInt(amount);
        }
        for (int i = 0; i < n; i++) {
            if (amounts[i] > 1000) {
                visited[i] = true;
            }
            for (int j = i + 1; j < n; j++) {
                if (names[i].equals(names[j]) && Math.abs(times[i] - times[j]) <= 60 && !cities[i].equals(cities[j])) {
                    visited[i] = true;
                    visited[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                res.add(transactions[i]);
            }
        }
        return res;        
    }
}