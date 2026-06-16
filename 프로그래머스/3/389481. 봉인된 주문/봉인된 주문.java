import java.util.*;

class Solution { 
    public String solution(long n, String[] bans) {
        // 26의 제곱값 저장
        long[] pow = new long[12];
        pow[0] = 1;

        for (int i = 1; i <= 11; i++) {
            pow[i] = pow[i - 1] * 26;
        }

        // 삭제된 주문들을 원래 주문서 기준 순번으로 바꾸기
        long[] banNums = new long[bans.length];

        for (int i = 0; i < bans.length; i++) {
            banNums[i] = wordToNumber(bans[i], pow);
        }

        // 삭제된 주문 순번 정렬
        Arrays.sort(banNums);

        // 삭제된 주문이 n번째보다 앞에 있으면 위치가 뒤로 밀림
        long target = n;

        for (long ban : banNums) {
            if (ban <= target) {
                target++;
            } else {
                break;
            }
        }

        // 최종 순번을 다시 문자열로 바꾸기
        return numberToWord(target, pow);
    }

    // 문자열을 원래 주문서 기준 순번으로 바꾸는 함수
    private long wordToNumber(String word, long[] pow) {
        int len = word.length();
        long num = 0;

        // 현재 단어보다 짧은 길이의 단어 개수 더하기
        for (int i = 1; i < len; i++) {
            num += pow[i];
        }

        // 같은 길이 안에서 몇 번째인지 계산
        long value = 0;

        for (int i = 0; i < len; i++) {
            value = value * 26 + (word.charAt(i) - 'a');
        }

        // value는 0부터 시작하니까 1 더하기
        return num + value + 1;
    }

    // 순번을 문자열로 바꾸는 함수
    private String numberToWord(long num, long[] pow) {
        int len = 1;

        // 몇 글자짜리 단어인지 찾기
        while (num > pow[len]) {
            num -= pow[len];
            len++;
        }

        // 0부터 시작하도록 1 빼기
        num--;

        char[] result = new char[len];

        // 뒤에서부터 문자 채우기
        for (int i = len - 1; i >= 0; i--) {
            result[i] = (char) ('a' + (num % 26));
            num /= 26;
        }

        return new String(result);
    }
}