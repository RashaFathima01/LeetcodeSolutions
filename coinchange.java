class Solution {
    public int coinChange(int[] coin, int amount) {
        int[] minCoin = new int[amount + 1];
        Arrays.fill(minCoin, amount + 1);
        minCoin[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coin.length; j++) {
                if (i - coin[j] >= 0) {
                    minCoin[i] = Math.min(minCoin[i], 1 + minCoin[i - coin[j]]);
                }
            }
        }

        return minCoin[amount] != amount + 1 ? minCoin[amount] : -1;        
    }
}