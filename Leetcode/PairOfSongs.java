public class PairOfSongs {

    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
    }

    public static int numPairsDivisibleBy60(int[] time) {

        int[] seen = new int[60];
        int numPairs = 0;

        for (int j : time) {
            numPairs += seen[(60 - (j % 60)) % 60];
            seen[j % 60]++;
        }
        return numPairs;
    }
}
