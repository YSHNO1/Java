public class Solution {
    //背包问题
    public int testWeightBagProblem(int[] weight, int[] value, int bagSize){
        int[][] dp = new int[weight.length + 1][bagSize + 1];
        //初始化
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j = weight[0]; j <= bagSize; j++){
            dp[0][j] = value[0];
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; i < dp[0].length; j++){
                if(j < weight[i - 1]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        return dp[weight.length - 1][bagSize - 1];
    }

    public static void main(String[] args) {
        int[] weight = new int[]{1, 3, 4};
        int[] value = new int[]{15, 20, 30};
        Solution solution = new Solution();
        int res = solution.testWeightBagProblem(weight, value, 4);
        System.out.println(res);
    }
}
