package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//"25525511135"
class Solution {
    static ArrayList<String> res;
    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
        for (String q : res) {
            System.out.println(q);
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        dfs(s,new ArrayList<String>());
        return res;
    }

    public static void dfs(String s, ArrayList<String> list) {
        if (list.size() == 4 && s.length() == 0 && s.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String t : list) {
                sb.append(t).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            String tmp = s.substring(0,i);
            if (!checkNum(tmp)) return;
            list.add(tmp);
            dfs(s.substring(i, s.length()), list);
            list.remove(list.size() - 1);
        }
    }

    public static boolean checkNum(String num) {
        if (num.charAt(0) == '0' && num.length() > 1) return false;
        if (Integer.parseInt(num) < 0 || Integer.parseInt(num) > 255) return false;
        return true;
    }

}