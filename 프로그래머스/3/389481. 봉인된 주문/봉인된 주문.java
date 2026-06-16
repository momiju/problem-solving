import java.util.*;

class Solution { 
    public String solution(long n, String[] bans) {
        long[] pow = new long[12];
        pow[0] = 1;

        for (int i = 1; i <= 11; i++) {
            pow[i] = pow[i - 1] * 26;
        }

        long[] banNums = new long[bans.length];

        for (int i = 0; i < bans.length; i++) {
            banNums[i] = wordToNumber(bans[i], pow);
        }

        Arrays.sort(banNums);

        long target = n;

        for (long ban : banNums) {
            if (ban <= target) {
                target++;
            } else {
                break;
            }
        }

        return numberToWord(target, pow);
    }

    private long wordToNumber(String word, long[] pow) {
        int len = word.length();
        long num = 0;

        for (int i = 1; i < len; i++) {
            num += pow[i];
        }

        long value = 0;

        for (int i = 0; i < len; i++) {
            value = value * 26 + (word.charAt(i) - 'a');
        }

        return num + value + 1;
    }

    private String numberToWord(long num, long[] pow) {
        int len = 1;

        while (num > pow[len]) {
            num -= pow[len];
            len++;
        }

        num--;

        char[] result = new char[len];

        for (int i = len - 1; i >= 0; i--) {
            result[i] = (char) ('a' + (num % 26));
            num /= 26;
        }

        return new String(result);
    }
}
