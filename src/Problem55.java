public class Problem55 {
    /**
     * the numeric value of sum may overflow the Long.MAX_VALUE. I solved this by using calculation of strings
     * */
    public static int countLychrel(){
        int count = 0;
        for(int i = 1; i < 10000; i ++) {
            if(isLychrel(i)) count ++;
        }
        return count;
    }
    private static boolean isLychrel(long num){
        String s = String.valueOf(num);
        for(int i = 0; i < 50; i ++) {
            s = add(s, getReverse(s));
            if(isPalindrome(s)) return false;
        }
        return true;
    }
    private static String getReverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if(s.charAt(left ++) != s.charAt(right --)) return false;
        }
        return true;
    }
    private static String add(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int i = len1 - 1, j = len2 - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if(i >= 0) sum += (s1.charAt(i --) - '0');
            if(j >= 0) sum += (s2.charAt(j --) - '0');
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if(carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
