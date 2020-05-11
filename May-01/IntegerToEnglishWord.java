class Solution {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return tanslate(num);
    }

    private String tanslate(int num) {
        String result =  new String();
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num - 10];
        else if (num < 100) result = belowHundred[num/10] + " " + translate(num%10);
        else if (num < 1000) result = translate(num/100) + " Hundred " + translate(num%100);
        else if (num < 1000000) result = translate(num/1000) + " Thousand " + translate(num%1000);
        else if (num < 1000000000) result = translate(num/1000000) + " Million " + translate(num%1000000);
        else result = translate(num/1000000000) + " Billion " + translate(num%1000000000);
        return result.trim();

    }
}