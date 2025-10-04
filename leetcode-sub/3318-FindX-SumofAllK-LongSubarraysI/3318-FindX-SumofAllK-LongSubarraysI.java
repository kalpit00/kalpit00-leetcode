// Last updated: 10/4/2025, 6:18:49 AM
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            // Subarray is nums[i] to nums[i + k - 1]
            Map<Integer, Integer> freqMap = new HashMap<>();
            
            // 1. Count the occurrences of all elements in the subarray
            for (int j = i; j < i + k; j++) {
                freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);
            }

            // The list of unique elements to be sorted based on frequency and value.
            List<Integer> uniqueElements = new ArrayList<>(freqMap.keySet());
            
            // Note: If the subarray has less than x distinct elements, uniqueElements.size() < x.
            // The logic below still works because it takes Math.min(x, uniqueElements.size()) elements.

            // 2. Sort the unique elements based on the required criteria:
            //    Primary: descending frequency (more frequent first).
            //    Secondary: descending value (bigger value first for ties).
            Collections.sort(uniqueElements, new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    int freqA = freqMap.get(a);
                    int freqB = freqMap.get(b);

                    // Sort by frequency (descending)
                    if (freqA != freqB) {
                        return Integer.compare(freqB, freqA);
                    }
                    // Sort by value (descending) for ties in frequency
                    return Integer.compare(b, a);
                }
            });

            long xSum = 0;
            // 3. Keep only the top x most frequent elements and calculate the sum
            int elementsToConsider = Math.min(x, uniqueElements.size());
            
            for (int m = 0; m < elementsToConsider; m++) {
                int element = uniqueElements.get(m);
                int frequency = freqMap.get(element);
                
                // Add the contribution of this element (element * frequency) to the x-sum
                xSum += (long) element * frequency;
            }

            answer[i] = (int) xSum;
        }

        return answer;
    }
}