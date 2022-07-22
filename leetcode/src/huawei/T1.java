package huawei;

import java.util.Scanner;

//T1 考试得分总数
//        员工参加考试，判断题X10（每个2分），单选题X10（每个4分），多选题X5（每个八分）。
//        只能顺序作答，答对得分，答错不得分。答错三道，中止考试。
//        输入考试结果分数，输出答题可能情况个数
public class T1 {
    public static int N;
    public static int[] scores = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4,4, 4, 8, 8, 8, 8, 8};
    public static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        backtrack(0, 0, 0);
        System.out.println(res);
    }
    public static void backtrack(int index, int score, int err){
        if(err >= 3) return;
        if(score >= N){
            if(score == N){
                res++;
            }
            return;
        }
        for(int i = index; i < scores.length; i++){
            score += scores[index];
            backtrack(i + 1, score, err);
            score -= scores[index];
            err++;
        }
    }
}
