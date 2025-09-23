// Last updated: 9/23/2025, 12:38:44 AM
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] revision1 = version1.split("\\.");
        String[] revision2 = version2.split("\\.");
        int m = revision1.length, n = revision2.length; 
        int length = Math.max(m, n);
        for (int i = 0; i < length; i++) {
            Integer v1 = i < m ? Integer.parseInt(revision1[i]) : 0;
            Integer v2 = i < n ? Integer.parseInt(revision2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }
}