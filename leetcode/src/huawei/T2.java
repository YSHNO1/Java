package huawei;

import java.util.*;

/**
 * T2 按路径替换二叉树
        将一棵根二叉树按照给定路径，替换其中一部分为另一棵子二叉树。
        输入
        第一行：一个数组，表示根二叉树，空节点用0表示
        格式-> [1,1,2,0,0,4,5]
        第二行：一个字符串，表示要替换位置所在的节点
        格式-> /1/2
        第三行：一个数组，表示子二叉树，空节点用0表示
        格式-> [5,3,0]
        输出
        一个数组，表示替换后的根二叉树，空节点跳过
        格式-> [1,1,5,3]
 **/
public class T2 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        TreeNode root = deserialize(str);
        str = sc.nextLine(); //要替换的节点
        TreeNode p = search(root, str);
        str = sc.nextLine(); //要换上去的树
        TreeNode root2 = deserialize(str);
        List<Integer> res = new ArrayList<>();
        if(root == p){
            for(int i = 1; i < str.length(); i += 2){
                if(str.charAt(i) != 0) res.add(str.charAt(i) - '0');
            }
        } else if(root.left == p){
            root.left = root2;
            res = serialize(root);
        } else {
            root.right = p;
            res = serialize(root);
        }

        //打印输出
        for(int i = 0; i < res.size(); i++){
            if(i == 0) System.out.print("[");
            if(i != res.size() - 1){
                System.out.print(res.get(i));
                System.out.print(",");
            } else {
                System.out.print(res.get(i));
                System.out.print("]");
            }
        }
    }

    //根据数组字符串建树
    public static TreeNode deserialize(String str){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root;
        char[] chars = str.toCharArray();
        int index = 1;
        root = new TreeNode(chars[index] - '0');
        queue.offer(root);
        index += 2;
        while(index < chars.length){
            int tmp = chars[index] - '0';
            if(tmp != 0){
                queue.peek().left = new TreeNode(tmp);
                queue.offer(queue.peek().left);
            }
            index += 2;
            if(index > chars.length) break;
            tmp = chars[index] - '0';
            if(tmp != 0){
                queue.peek().right = new TreeNode(tmp);
                queue.offer(queue.peek().right);
            }
            index += 2;
            queue.poll();
        }
        return root;
    }

    //替换树中的某个节点
    public static TreeNode search(TreeNode root, String str){
        TreeNode tmp = root;
        for(int i = 3; i < str.length(); i += 2){
            if(tmp.left != null && tmp.left.val == str.charAt(i) - '0'){
                tmp= tmp.left;
            } else{
                tmp = tmp.right;
            }
        }
        return tmp;
    }
    //层序遍历输出树
    public static List<Integer> serialize(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node.val);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        return res;
    }

}
