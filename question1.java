import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MinSquareSum {
    int minvalue(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while (k > 0) {
            char ch = max(map);
            if (map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
                k--;
            }
        }

        int min = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            min += entry.getValue() * entry.getValue();
        }
        return min;
    }

    char max(HashMap<Character, Integer> map) {
        int maxFreq = 0;
        char maxChar = '\0';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        return maxChar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string:");
        String str = sc.nextLine();
        System.out.println("Enter k:");
        int k = sc.nextInt();
        sc.close();

        MinSquareSum obj = new MinSquareSum();
        System.out.println("Minimum square sum: " + obj.minvalue(str, k));
    }
}
