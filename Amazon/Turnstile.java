 private static int[] amazonTurnstile(int numCustomers, int[] arrTime, int[] direction){
        int prevD = 1;
        int curTime = 0;

        int[] output = new int[numCustomers];

        Queue<int[]> enterQ = new LinkedList<>();
        Queue<int[]> exitQ = new LinkedList<>();

        for (int i = 0; i < numCustomers; i++) {
            if (direction[i] == 0) {
                enterQ.add(new int[]{arrTime[i], i});
            } else {
                exitQ.add(new int[]{arrTime[i], i});
            }
        }

        while (!enterQ.isEmpty() && !exitQ.isEmpty()) {
            int[] entry = enterQ.peek();
            int[] exit = exitQ.peek();

            if (Math.abs(Math.min(entry[0], exit[0]) - curTime) > 1) {
                prevD = 1;
            }

            if (entry[0] > exit[0]) {
                curTime = Math.max(curTime, exit[0]);
                output[exit[1]] =curTime;
                exitQ.poll();
                prevD = 1;
            } else if (entry[0] < exit[0]) {
                curTime = Math.max(curTime, entry[0]);
                output[entry[1]] = curTime;
                enterQ.poll();
                prevD = 0;
            } else { //equal
                if (prevD == 1) {
                    curTime = Math.max(curTime, exit[0]);
                    output[exit[1]] =curTime;
                    entry[0]++;
                    exitQ.poll();
                } else {
                    curTime = Math.max(curTime, entry[0]);
                    output[entry[1]] = curTime;
                    exit[0]++;
                    enterQ.poll();
                }
            }
            curTime++;
        }

        while (!enterQ.isEmpty()) {
            int[] entry = enterQ.poll();
            curTime = Math.max(curTime, entry[0]);
            output[entry[1]] = curTime;
            curTime++;
        }

        while(!exitQ.isEmpty()) {
            int[] exit = exitQ.poll();
            curTime = Math.max(curTime, exit[0]);
            output[exit[1]] = curTime;
            curTime++;
        }
        return output;
    }