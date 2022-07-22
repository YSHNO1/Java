package codeTop;

//36进制加法，0-9，a-z 代表 10~35
public class addStrings {
    //将字母转换为具体的数字
    public static int cton(char c){
        if(c >= '0' && c <= '9'){
            return c - '0';
        } else {
            return c - 'a' + 10;
        }
    }
    //将字母转换为数字
    public static char ntoc(int num){
        if(num <= 9){
            return (char) ('0' + num);
        } else {
            return (char) ('a' + num - 10);
        }
    }
    public static String add(String nums1, String nums2){
        int i = nums1.length() - 1, j = nums2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >=  0 || j >= 0 || carry != 0){
            carry += i >= 0 ? cton(nums1.charAt(i)) : 0;
            carry += j >= 0 ? cton(nums2.charAt(i)) : 0;
            sb.append(ntoc(carry % 36));
            carry = carry / 36;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {

        String num1 = "1b";
        String num2 = "2x";
        String res = add(num1, num2);
        System.out.println(res);
    }
}
