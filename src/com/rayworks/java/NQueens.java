package com.rayworks.java;

/**
 * Created by Shirley on 7/18/16.
 */
public class NQueens {

    static int n = 8;
    public static void main(String[] args) {

        int[] array = new int[n];
        recursiveNQueens(array, 0);
    }

    private static void recursiveNQueens(int[] Q, int r) {
        if(r == n){
            // print Q
        }else{
            for(int j =0; j< n; j++){
                boolean legal = true;
                for (int i = 0; i < r; i++){
                    if(Q[i] == j || Q[i] == j + r -i || Q[i] == j -r + i) {
                        legal = false;
                        //break;
                    }

                }
                if(legal){
                    Q[r] = j;
                    recursiveNQueens(Q, r + 1);
                }
            }
        }
    }
}
