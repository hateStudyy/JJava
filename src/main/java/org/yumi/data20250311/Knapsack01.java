package org.yumi.data20250311;

public class Knapsack01 {

    public static void main(String[] args) {
        // 示例数据
        int[] weights = {1, 3, 4};    // 物品重量
        int[] values = {15, 20, 30};  // 物品价值
        int capacity = 4;            // 背包容量
        
        int maxValue = knapsack01(weights, values, capacity);
        System.out.println("最大价值: " + maxValue);
    }

    /**
     * 0-1背包动态规划解法
     * @param weights 物品重量数组
     * @param values 物品价值数组
     * @param capacity 背包容量
     * @return 最大可获取价值
     */
    public static int knapsack01(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // 创建动态规划表 dp[i][w] 表示前i个物品在容量w时的最大价值
        int[][] dp = new int[n + 1][capacity + 1];

        // 初始化基础情况：0个物品时价值为0
        for (int w = 0; w <= capacity; w++) {
            dp[0][w] = 0;
        }

        // 填充动态规划表
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                // 当前物品的重量和价值（注意索引偏移）
                int currentWeight = weights[i - 1];
                int currentValue = values[i - 1];

                if (currentWeight > w) {
                    // 当前物品太重，无法放入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 选择放入或不放入当前物品的较优解
                    dp[i][w] = Math.max(
                            dp[i - 1][w],  // 不放当前物品
                            dp[i - 1][w - currentWeight] + currentValue  // 放当前物品
                    );
                }
            }
        }

        return dp[n][capacity];
    }
}