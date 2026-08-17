import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();

        // 오늘 날짜를 숫자로 변환
        String[] t = today.split("\\.");
        int todayDate = Integer.parseInt(t[0]) * 12 * 28 + Integer.parseInt(t[1]) * 28 + Integer.parseInt(t[2]);

        // 개인정보 하나씩 확인
        for(int i = 0; i < privacies.length; i++){
            String[] p = privacies[i].split(" ");
            String[] d = p[0].split("\\.");

            int date = Integer.parseInt(d[0]) * 12 * 28 + Integer.parseInt(d[1]) * 28 + Integer.parseInt(d[2]);

            // 약관 개월 수 찾기
            int month = 0;

            for(int j = 0; j < terms.length; j++){
                String[] term = terms[j].split(" ");

                if(term[0].equals(p[1])){
                    month = Integer.parseInt(term[1]);
                    break;
                }
            }

            // 유효기간 더하기
            date += month * 28;

            // 오늘보다 작거나 같으면 파기
            if(date <= todayDate){
                list.add(i + 1);
            }
        }

        // ArrayList -> 배열
        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}