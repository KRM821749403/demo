package com.main;

import java.util.*;

public class Main {
    static HashSet<Character> set;

    public static void main(String[] args) {
        System.out.println("asdasdsadas");
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        set = new HashSet();
        set.add('a');set.add('A');set.add('e');set.add('E');set.add('i');set.add('I');set.add('o');
        set.add('O');set.add('u');set.add('U');
        ArrayList<Integer> list = new ArrayList();
        String s = sc.nextLine();
        for(int i = 0;i < s.length();i++){
            if(set.contains(s.charAt(i))) list.add(i);
        }
        int a [] = {1,2,3};


        System.out.println(getLongSub(list,s,k));

    }
    public static int getLongSub(ArrayList<Integer> list,String s,int k){
        int res = 0;
        for(int i = 1;i < list.size();i++){
            if((list.get(i) - list.get(i-1)) == (k+1)){
                int start = list.get(i-1);
                System.out.println(start);
                int end = list.get(i);
                while(end < s.length() && set.contains(s.charAt(end))) end++;
                while(start >= 0 && set.contains(s.charAt(start))) start--;
                //System.out.println(start+","+end);
                res = Math.max(res,end-start);
            }
        }
        return  res;
    }


}