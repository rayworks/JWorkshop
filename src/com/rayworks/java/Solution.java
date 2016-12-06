package com.rayworks.java;

import java.util.*;

/**
 * Created by Shirley on 11/2/16.
 */
public class Solution {
    public List<String> getAllWords(String s) {
        LinkedList<String> result = new LinkedList();
        if (s == null || s.length() == 0) {
            return result;
        }
        int cnt = s.length();


        if (cnt == 2) {
            // add the word
            result.add(s);
            result.add("" + s.charAt(1) + s.charAt(0));

            return result;
        }

        for (int i = 0; i < cnt; i++) {
            char ch = s.charAt(0);

            // gather all the results for current order
            List<String> rest = getAllWords(s.substring(1));
            for (String str : rest) {
                result.add("" + ch + str);
            }

            // rotate words
            s = s.substring(1) + s.charAt(0);

        }

        return result;

    }

    public boolean isAnagram(String s, String t) {
        // via hash


        if (s.equals("")) {
            if (t.equals("")) {
                return true;
            }
            return false;
        }

        if (s.length() == 1) {
            return s.equals(t);
        }

        HashMap<String, Integer> srcMap = formHashMap(s);
        HashMap<String, Integer> compMap = formHashMap(t);

        if (srcMap.size() != compMap.size()) {
            return false;
        }

        Set<String> keys = srcMap.keySet();
        for (String k : keys) {
            if (compMap.get(k) == null || srcMap.get(k).intValue() != compMap.get(k).intValue()) {
                return false;
            }
        }
        return true;

        /*Set<String> rt = new HashSet<String>();
        rt.addAll(getAllWords(s));

        return rt.contains(t);*/

    }

    private HashMap<String, Integer> formHashMap(String s) {
        int len = s.length();
        HashMap<String, Integer> maps = new HashMap<String, Integer>();
        for (int j = 0; j < len; j++) {
            char ch = s.charAt(j);
            String key = "" + ch;
            if (maps.containsKey(key)) {
                int cnt = maps.get(key);
                ++cnt;
                maps.put(key, cnt);
            } else {
                maps.put(key, 1);
            }
        }

        return maps;
    }

    /***
     * "dgqztusjuu"
     * "dqugjzutsu"
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        Object[] objects = (solution.getAllWords("abc")).toArray();
        System.out.println("Result size: " + objects.length);
        System.out.println(">>> all words: " + Arrays.toString(objects));


        System.out.println("isAnagram ? " + solution.isAnagram("dgqztusjuu", "dqugjzutsu"));
    }
}
