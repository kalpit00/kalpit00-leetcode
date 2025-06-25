// Last updated: 6/25/2025, 4:00:28 PM
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        Set<String> seenSequences = new HashSet<>();
        Set<String> repeatedSequences = new HashSet<>();

        for(int i=0;i<=s.length()-10;i++)
        {
            String subsequence = s.substring(i,i+10);

            if(!seenSequences.add(subsequence))
            {
                repeatedSequences.add(subsequence);
            }
        }

        return new ArrayList<>(repeatedSequences);
    }
}