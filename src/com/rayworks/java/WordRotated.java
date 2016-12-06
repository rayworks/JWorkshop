package com.rayworks.java;

import java.util.*;

/**
 * Created by Shirley on 7/10/16.
 */
public class WordRotated {
    public static List<String> getAllRotates(String word) {
        /***
         * word
         *  ord |
         *   rd | dr
         *   d
         *  rdo |
         *   do | od
         *   o
         *  dor |
         *   or | ro
         *   r
         *  ------------
         * ordw
         *  rdw
         *   dw | wd
         *   w
         *
         *  if 1:
         *      A[i]
         *  if 2:
         *      switch
         *  if 3+:
         *      A(1-n)|A0
         */

        /*if(word.length() == 1){
            return Arrays.asList(word);
        }*/

        if(word.length() == 2){
            StringBuilder builder = new StringBuilder();
            String cp = builder.append(word.charAt(1)).append(word.charAt(0)).toString();
            return Arrays.asList(word, cp);
        }

        ArrayList<String> results = new ArrayList<String>();
        for(int i = 0 ; i < word.length(); i ++){
            List<String> strs = getAllRotates(word.substring(1));
            for (String s : strs) {
                results.add(word.charAt(0) + s);
            }

            // rotate the left char to the most right position for N times.
            word = word.substring(1) + word.charAt(0);
        }
        // d&c
        return results;

        /***
         * word
         * w-> ord
         *  o-> rd
         *   *rd
         *    => word
         *    => wodr
         *  => word
         *  => wdro
         * =>
         *    rdo
         *   *trans() - > dr
         *
         *   C41 + c31 + c21
         *
         *
         */
        // print self;
        // print rotated one

        /*Set<String> sets = new HashSet<String>();
        LinkedList<String> strs = new LinkedList<String>();
        int cnt = word.length();
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                sets.add(getRotated(word, i, j));
            }
        }

        for (String s : sets) {
            strs.add(s);
        }

        return strs;*/
    }

    public static String getRotated(String str, int srcPos, int destPos) {
        if (srcPos == destPos)
            return str;
        else {
            StringBuilder builder = new StringBuilder();
            char chSrc = str.charAt(srcPos);
            char chDest = str.charAt(destPos);

            for (int i = 0; i < str.length(); i++) {
                if (i == srcPos) {
                    builder.append(chDest);
                } else if (i == destPos) {
                    builder.append(chSrc);
                } else {
                    builder.append(str.charAt(i));
                }
            }

            /*if(srcPos == 0){
                String rt = str.substring(1) + chSrc;
                builder.append(rt)
            }else if(srcPos == str.length() - 1){

            }*/
            return builder.toString();
        }

    }

    /***
     * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
     Return:

     [
     ["ate", "eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]

     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> groupedStrs = new LinkedList<List<String>>();
        List<Set<String>> sets = new LinkedList<Set<String>>();
        for(int i =0; i < strs.length; i++){
            String elem = strs[i];
            boolean found = false;
            int j = 0;
            for(Set<String> set: sets){
                if(set.contains(elem)){
                    found = true;
                    break;
                }
                ++j;
            }

            if(!found){
                List<String> results = getAllRotates(elem);
                sets.add(new HashSet(results));

                groupedStrs.add(new LinkedList(Arrays.asList(elem)));
            }else{
                List<String> elems = groupedStrs.get(j);
                if (elem.compareTo(elems.get(0)) < 0) {
                    elems.add(0, elem);
                } else if (elem.compareTo(elems.get(elems.size() - 1)) > 0) {
                    elems.add(elem);
                } else {
                    // insert into the middle
                    int destPos = 0;
                    for (int pos = 1; pos < elems.size() - 1; pos++) {
                        if (elem.compareTo(elems.get(pos - 1)) > 0 && elem.compareTo(elems.get(pos)) < 0) {
                            destPos = pos;
                            break;
                        }
                    }
                    elems.add(destPos, elem);
                }
            }
        }

        return groupedStrs;
    }

    public static void main(String[] args) {
        String word = "cats";
        System.out.println(String.format(">>> %s rotated result: ", word));

        List<String> words = getAllRotates(word);

        System.out.println("Size of all words: " + words.size());
        for (int i = 0 ; i < words.size(); i++){

            if(i % 6 == 0 && i > 0){
                System.out.print("\n");
                System.out.print(words.get(i));
                System.out.print(" ");
            }else{
                System.out.print(words.get(i));
                System.out.print(" ");
            }
        }
        //System.out.println(Arrays.toString(words.toArray(new String[words.size()])));

        String[] testWords = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> results = groupAnagrams(testWords);
        System.out.println("Group operation done.");
    }
}
