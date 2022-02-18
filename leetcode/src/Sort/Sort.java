package Sort;

import java.util.Arrays;

public class Sort {
    int[] nums = new int[]{2, 4, 3, 1, 6, 5};

    //冒泡排序 带优化
    public void bubbleSort(int[] a){
        for(int i = a.length - 1; i >= 0; i--){
            int flag = 0;
            for(int j = 0; j < i; j++){
                if(a[j] > a[j + 1]){
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    flag = 1;
                }
            }
            if(flag == 0) break;
        }
    }

    //快速排序

    public void quickSort(int[] a, int l, int r){
        if(l < r){
            int x = a[l], i = l, j = r;
            while(i < j){
                //从右向左比较
                while(i < j && a[j] > x){
                    j--;
                }
                if(i < j){
                    a[i] = a[j];
                    i++;
                }
                //从左向右比较
                while(i < j && a[i] < x){
                    i++;
                }
                if(i < j) {
                    a[j] = a[i];
                    j--;
                }
            }
            a[i] = x;
            quickSort(a, l, i - 1);
            quickSort(a, i + 1, r);
        }
    }

    //直接插入排序
    public void insertSort(int[] a){
        int i, j, k;
        for(i = 1; i < a.length; i++){
            for(j = i - 1; j >= 0; j--){
                if(a[i] > a[j]) break;
            }
            //找到了插入位置，开始移动元素
            if(j != i - 1){
                int temp = a[i];
                for(k = i - 1; k > j; k--){
                    a[k + 1] = a[k];
                }
                a[k + 1] = temp;
            }
        }
    }

    //希尔排序
    public void shellSort(int[] a){

    }

    public static void main(String[] args) {
        Sort sort = new Sort();
//        sort.bubbleSort(sort.nums);
//        sort.quickSort(sort.nums, 0, sort.nums.length - 1);
        sort.insertSort(sort.nums);
        System.out.println("排序后：" + Arrays.toString(sort.nums));
    }
}
