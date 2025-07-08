// Last updated: 7/8/2025, 12:12:23 PM
class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            String[] parts = queryIP.split("\\.", -1);  // -1 keeps empty strings
            if (parts.length != 4) return "Neither";
            for (String part : parts) {
                if (!checkIPv4Part(part)) return "Neither";
            }
            return "IPv4";
        } else if (queryIP.contains(":")) {
            String[] parts = queryIP.split(":", -1);
            if (parts.length != 8) return "Neither";
            for (String part : parts) {
                if (!checkIPv6Part(part)) return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }
    public boolean checkIPv4Part(String s){
        if (s.length() == 0 || s.length() > 3) return false;
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        try {
            int num = Integer.parseInt(s);
            return num >= 0 && num <= 255;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkIPv6Part(String s){
        if (s.length() == 0 || s.length() > 4) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) &&
                !(c >= 'a' && c <= 'f') &&
                !(c >= 'A' && c <= 'F')) {
                return false;
            }
        }
        return true;
    }
}