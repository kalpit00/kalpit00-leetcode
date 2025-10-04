// Last updated: 10/4/2025, 6:11:30 AM
class Solution {
    public String convertDateToBinary(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        String binaryYear = Integer.toBinaryString(year);
        String binaryMonth = Integer.toBinaryString(month);
        String binaryDay = Integer.toBinaryString(day);
        return binaryYear + "-" + binaryMonth + "-" + binaryDay;
    }
}