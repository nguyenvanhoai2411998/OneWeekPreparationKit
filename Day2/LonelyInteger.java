package JavaSolution.OneWeekPrepare;

import java.util.*;

public class LonelyInteger {
    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            int count = 0;
            int key = a.get(i);
            if (map.containsKey(key)) {
                count = map.get(key);
                map.put(key, count + 1);
            }else map.put(key, 1);
        }

        for (int i = 0; i < a.size(); i++) {
            int key = a.get(i);
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
}

class LonelyIntegerResult{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>();
        while (n > 0){
            a.add(scanner.nextInt());
            n--;
        }
        System.out.println(LonelyInteger.lonelyinteger(a));
    }
}