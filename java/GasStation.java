public class GasStation {
    public static void main(String[] args) {
//        int[] gas = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        while (i < gas.length) {
            if (gas[i] < cost[i]) {
                i++;
            } else {
                int step = 1;
                int left = gas[i] - cost[i];
                while (step < gas.length && left >= 0) {
                    int j = (i + step) % gas.length;
                    left += gas[j] - cost[j];
                    step++;
                }
                if (step == gas.length && left >= 0) {
                    return i;
                } else if (i + step >= gas.length){
                    return -1;
                } else {
                    i = (i + step) % gas.length;
                }
            }
        }

        return -1;
    }
}
