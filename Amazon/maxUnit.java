public static int getMaxUnit(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox, long truckSize){
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int i=0;i<num;i++){
            int n = boxes.get(i);
            for(int j = 0;j < n;j++){
                int addItem = unitsPerBox.get(i);
                PQ.add(addItem);
                if(PQ.size() > truckSize) PQ.remove();
             }
        }
        int max = 0;
        while(!PQ.isEmpty()){
            max += PQ.remove();
        }
        return max;
    }