import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};

        HashMap<String, Integer> rank = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int index = rank.get(callings[i]);

            String temp = players[index - 1];

            players[index - 1] = players[index];
            players[index] = temp;

            rank.put(players[index - 1], index - 1);
            rank.put(players[index], index);
        }
        answer = players;

        return answer;
    }
}