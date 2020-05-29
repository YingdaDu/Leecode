class Solution {
    public String[] reorderLogFiles(String[] logs) {

        //从小到大排，LOG1 > LOG2 return 1
        //log1 == log2 return 0
        //log1 < log2 return -1

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {//两个都是字母
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) return cmp;
                    return split1[0].compareTo(split2[0]);
                }
                //如果1不是数字，2是数字，则2要排到后面，则2比较大，log1 < log2, return -1
                //如果都是数字，保持原有的order，则return 0
                //如果1是数字，2不是数字，2要排在1前面，log1 > log2, 则return 1
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            }
        };
        Arrays.sort(logs, comp);
        return logs;
    }

}