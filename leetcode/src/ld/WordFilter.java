package ld;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class WordFilter {
    Tire prefTire = new Tire();
    Tire suffTire = new Tire();
    //分别正序存储和倒叙存储，然后等级下标
    public WordFilter(String[] words) {
        for(int i = 0; i < words.length; i++){
            prefTire.insert(words[i], i);
            suffTire.insert(new StringBuilder(words[i]).reverse().toString(), i);
        }
    }

    public int f(String pref, String suff) {
        List<Integer> prefList = prefTire.search(pref);
        List<Integer> suffList = suffTire.search(new StringBuilder(suff).reverse().toString());
        if(prefList == null || suffList == null) return -1;
        // int res = Intger.MIN_VALUE;
        int i = prefList.size() - 1, j = suffList.size() - 1;
        while(i >= 0 && j >= 0){
            if(prefList.get(i) == suffList.get(j)){
                return prefList.get(i);
            } else if(prefList.get(i) > suffList.get(j)){
                i--;
            } else {
                j--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] words = s1.split(",");
        WordFilter wordFilter = new WordFilter(words);
        String[] str = s2.split(",");
        System.out.println(wordFilter.f(str[0], str[1]));
    }
}

class Tire{
    Node root;
    class Node{
        Node[] next;
        List<Integer> list;

        public Node(){
            next = new Node[26];
            list = new ArrayList<>();
        }
    }

    public Tire(){
        root = new Node();
    }
    //插入
    public void insert(String s, int index){
        Node cur = root;
        for(char c : s.toCharArray()){
            if(cur.next[c - 'a'] == null){
                cur.next[c - 'a'] = new Node();
            }
            cur.next[c - 'a'].list.add(index);
            cur = cur.next[c - 'a'];
        }
    }
    public List<Integer> search(String s){
        Node cur = root;
        for(char c : s.toCharArray()){
            if(cur.next[c - 'a'] == null){
                return null;
            }
            cur = cur.next[c - 'a'];
        }
        return cur.list;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
