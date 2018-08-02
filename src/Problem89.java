import java.util.*;
public class Problem89 {
    public static int count(String[] strs){
        int count = 0;
        for(String s : strs) {
            if(s.equals(int2Roman(roman2Int(s)))) count ++;
        }
        return count;
    }
    private static int roman2Int(String s){
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ret = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i ++) {
            if(i < chars.length - 1 && map.get(chars[i]) < map.get(chars[i + 1])) {
                ret -= map.get(chars[i]);
            } else {
                ret += map.get(chars[i]);
            }
        }
        return ret;
    }
    private static String int2Roman(int num){
        int[] arr = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i ++) {
            while (num >= arr[i]){
                num -= arr[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }
}
