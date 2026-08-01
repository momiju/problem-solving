class Solution {
    public int[] solution(long n) {
        int[] answer = {};

        long tmp = n;
        int cnt = 0;

        while (tmp > 0) {
            tmp = tmp / 10;
            cnt++;
        }
        answer = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            answer[i] = (int)(n % 10);
            n = n / 10;
        }

        return answer;
    }
}