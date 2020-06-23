class Solution {
    public String validIPAddress(String IP) {
        if(IP.equals("")) return "Neither";
        if(isIP4(IP)) return "IPv4";
        if(isIP6(IP)) return "IPv6";
        return "Neither";
    }

    public boolean isIP4(String IP){
        if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
            return false;
        }
        if (IP.chars().filter(ch -> ch == '.').count() != 3) return false;
        String[] temp = IP.split("\\.");
        for (String s : temp) {
            try{
                if(!String.valueOf(Integer.parseInt(s)).equals(s)) return false;
                if(Integer.parseInt(s)>255 || s.charAt(0)=='-' || s.charAt(0)=='+') return false;
            }
            catch(NumberFormatException e){
                return false;
            }
        }
        return true;
    }

    public boolean isIP6(String IP){
        if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
            return false;
        }
        if(IP.chars().filter(ch -> ch == ':').count() != 7) return false;
        String[] temp = IP.split(":");
        for (String s : temp) {
            if (!isIPv6(s)) {
                return false;
            }
        }
        return true;
    }

    private boolean isIPv6(String s) {
        if (s.length() > 4) return false;
        try {
            return Integer.parseInt(s, 16) >= 0 && s.charAt(0) != '-';
        } catch (NumberFormatException e) {
            return false;
        }
    }
}