package codeTop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CirDep {
    public static void main(String[] args) {
        int n;
        int[][] arr = new int[][]{{0,2}, {1,2}, {2, 3}, {2, 4}};
        //拓扑排序
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> inDeg = new ArrayList<>();
    }
}
