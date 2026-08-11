class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int l = 0;
        int r = 1;
        int profit = 0;

        while (r < n) {
            profit = Math.max(profit, prices[r] - prices[l]);

            if (prices[r] < prices[l]) {
                l++;
            } else {
                r++;
            }
        }

        return profit;
    }
}
