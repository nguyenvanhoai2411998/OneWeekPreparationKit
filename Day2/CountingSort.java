package JavaSolution.OneWeekPrepare;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = countingSort(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int []a = new int[100];
        Arrays.fill(a,0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < 100){
                a[arr.get(i)]++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length ; i++) {
            list.add(i,a[i]);
        }
        return  list;
    }
}
