package JavaSolution.OneWeekPrepare;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int size = arr.size();
        int p = 0;
        int n = 0;
        int z = 0;
        for (Integer i : arr) {
            if (i > 0) {
                p++;
            }else if (i < 0) {
                n++;
            }else z++;
        }
        System.out.format("%.6f%n",(float)p/size);
        System.out.format("%.6f%n",(float)n/size);
        System.out.format("%.6f%n",(float)z/size);
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
