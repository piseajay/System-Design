public class GasStation {

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        // gas = [1,2,3,4,5],
        //cost = [3,4,5,1,2]
        for (int gasStation = 0; gasStation < gas.length; gasStation++) {

            if (canTravel(gas, cost, gasStation)) {
                return gasStation;
            }
        }
        return -1;
    }

    private static boolean canTravel(int[] gas, int[] cost, int gasStation) {

        int tank = 0;
        int stationsTravelled = 0;

        while (stationsTravelled < gas.length) {

            tank = tank + gas[gasStation];

            if (!(tank >= cost[gasStation])) {
                return false;
            }
            tank -= cost[gasStation];
            stationsTravelled += 1;
            gasStation = (gasStation + 1) % gas.length;
        }
        return true;
    }
}
