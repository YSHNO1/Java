import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    private static int x = 0;
    public static void main(String[] args) {
        test t1 = new test();
        t1.x++;
        test t2 = new test();
        t2.x++;
        test.x++;
        t1.x--;
        System.out.println(x);
    }
    
//
//public List<Integer> findDisappearedNumbers(int[] nums) {
//    List<Integer> res = new ArrayList<>();
//    for(int i = 0; i < nums.length; i++){
//        // int index = Math.abs() - 1;
//        int index = Math.abs(nums[i]) - 1;
//        nums[index] = -nums[i];
//    }
//    for(int i = 0; i < nums.length; i++){
//        if(nums[i] > 0) res.add(i + 1);
//    }
//    return res;
//}
//public int[] platesBetweenCandles(String s, int[][] queries) {
//    //前缀和
//    int n = queries.length;
//    int[] res = new int[n];
//    int[] preSum = new int[s.length()];
//    int count = 0;
//    //预先计算每个位置前面的*的个数
//    for(int i = 0; i < s.length(); i++){
//        if(s.charAt(i) == '*'){
//            count++;
//        }
//        preSum[i] = count;
//    }
//    //预先计算找到边界的蜡烛
//    int[] left = new int[s.length()];
//    count = -1;
//    for(int i = 0; i < s.length(); i++){
//        if(s.charAt(i) == '|'){
//            count = i;
//        }
//        left[i] = count;
//    }
//    int[] right = new int[s.length()];
//    count = -1;
//    for(int i = n - 1; i >= 0; i--){
//        if(s.charAt(i) == '|'){
//            count = i;
//        }
//        right[i] = count;
//    }
//    //查询
//    for(int i = 0; i < n; i++){
//        int[] query = queries[i];
//        int x = right[query[0]], y = left[query[1]];
//        res[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
//    }
//    return res;
//}
//    public static void main(String[] args) {
//        String s = "**|**|***|";
//        int[][] queries = new int[][]{{2, 5}, {5,9}};
//        test test1 = new test();
//        System.out.println(Arrays.toString(test1.platesBetweenCandles(s, queries)));
//    }


//    public int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(nums, 1);
//        for(int i = 0; i < dp.length; i++){
//            for(int j = 0; j < i; j++){
//                if(nums[i] > nums[j]){
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        int res = 0;
//        for(int i = 0; i < dp.length; i++){
//            if(res < dp[i]) res = dp[i];
//        }
//        return res;
//    }
}

