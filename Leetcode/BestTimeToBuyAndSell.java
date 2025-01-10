public class BestTimeToBuyAndSell {

    public static void main(String[] args) {

        int result = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("result = " + result);
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int leastPrice = prices[0];
        int currentProfit;

        for (int day = 1; day < prices.length; day++) {
            currentProfit = prices[day] - leastPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
            leastPrice = Math.min(leastPrice, prices[day]);

        }
        return maxProfit;
    }
}
