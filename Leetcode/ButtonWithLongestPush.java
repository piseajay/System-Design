public class ButtonWithLongestPush {
    
    public static void main(String[] args) {
        System.out.println(buttonWithLongestTime(new int[][]{{5, 4}, {20, 14}}));
    }

    public static int buttonWithLongestTime(int[][] events) {

        int maxTime = events[0][1];
        int indexOfMaxTime = events[0][0];

        for (int i = 1; i < events.length; i++) {
            int currentTime = events[i][1] - events[i - 1][1];
            if (currentTime > maxTime || (currentTime == maxTime && events[i][0] < indexOfMaxTime)) {
                maxTime = currentTime;
                indexOfMaxTime = events[i][0];
            }
        }
        return indexOfMaxTime;
    }
}
