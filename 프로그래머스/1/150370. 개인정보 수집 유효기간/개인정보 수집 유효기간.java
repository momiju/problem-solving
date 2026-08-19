import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();

        String[] t = today.split("\\.");
        int todayDate = Integer.parseInt(t[0]) * 12 * 28 + Integer.parseInt(t[1]) * 28 + Integer.parseInt(t[2]);

        for(int i = 0; i < privacies.length; i++){
            String[] p = privacies[i].split(" ");
            String[] d = p[0].split("\\.");

            int date = Integer.parseInt(d[0]) * 12 * 28 + Integer.parseInt(d[1]) * 28 + Integer.parseInt(d[2]);

            int month = 0;

            for(int j = 0; j < terms.length; j++){
                String[] term = terms[j].split(" ");

                if(term[0].equals(p[1])){
                    month = Integer.parseInt(term[1]);
                    break;
                }
            }

            date += month * 28;

            if(date <= todayDate){
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}