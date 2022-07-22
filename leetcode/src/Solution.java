import java.util.*;


class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
            int k = queries[i][0], trim = queries[i][1];
            for(int j = 0; j < nums.length; j++){
                queue.offer(new int[]{Integer.parseInt(nums[j].substring(nums[j].length() - trim).trim()) ,j});
                if(queue.size() > k) queue.poll();
            }
            res[i] = queue.peek()[1];
        }
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] nums = new String[]{"64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"};
        int[][] queries = {{5, 10}};
        int[] res = s.smallestTrimmedNumbers(nums, queries);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
