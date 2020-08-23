public static int buyFruits(List<List<String>> codeList, List<String> shoppingCart) {
        // Write your code here
        //edge case
        if (codeList == null || codeList.size() == 0) return 1; //no need to buy

        if (shoppingCart == null || shoppingCart.size() == 0) return 0;


        List<String> flattenCodeList = new ArrayList<>();

        for (List<String> l : codeList) {
            for (String s : l) {
                flattenCodeList.add(s);
            }
        }

        int codeLen = flattenCodeList.size();
        int len = shoppingCart.size();

        if (codeLen > len) {
            return 0;
        }

        for (int i = 0; i + codeLen <= len; i++) {
            for (int j = 0; j < codeLen; j++) {
                if (flattenCodeList.get(j).equals("anything")) {
                    if (j == codeLen - 1) return 1;
                    continue;
                }

                if (!flattenCodeList.get(j).equals(shoppingCart.get(i+j))) {
                    break;
                }

                if (j == codeLen - 1) {
                    return 1;
                }
            }
        }
            return 0;
}
