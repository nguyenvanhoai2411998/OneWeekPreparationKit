package JavaSolution.OneWeekPrepare;

import java.io.*;
import java.util.*;

class MiniMaxSum {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        int maximum = 0;
        int minimum = 0;
        for (Integer integer : arr) {
            if(integer > max) max = integer;
            if(integer < min) min = integer;
        }
        for (Integer integer : arr) {
            if (max != min) {
                if(integer != max) minimum += integer;
                if(integer != min) maximum += integer;
            }else{
                minimum = min*4;
                maximum = minimum;
            }

        }
        System.out.println(minimum +" "+maximum);
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        MiniMaxSum.miniMaxSum(arr);

        bufferedReader.close();
    }
}
