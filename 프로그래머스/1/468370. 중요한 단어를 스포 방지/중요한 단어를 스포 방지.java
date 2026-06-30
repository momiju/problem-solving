import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();

        int[] spoilerIndex = new int[n];
        Arrays.fill(spoilerIndex, -1);

        for (int i = 0; i < spoiler_ranges.length; i++) {
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];

            for (int j = start; j <= end; j++) {
                spoilerIndex[j] = i;
            }
        }

        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> openAt = new ArrayList<>();
        ArrayList<String> normalWords = new ArrayList<>();

        int idx = 0;

        while (idx < n) {
            if (message.charAt(idx) == ' ') {
                idx++;
                continue;
            }

            StringBuilder sb = new StringBuilder();

            boolean isSpoilerWord = false;
            int lastSpoilerRange = -1;

            while (idx < n && message.charAt(idx) != ' ') {
                sb.append(message.charAt(idx));

                if (spoilerIndex[idx] != -1) {
                    isSpoilerWord = true;
                    lastSpoilerRange = Math.max(lastSpoilerRange, spoilerIndex[idx]);
                }

                idx++;
            }

            String word = sb.toString();

            words.add(word);
            openAt.add(lastSpoilerRange);

            if (!isSpoilerWord) {
                normalWords.add(word);
            }
        }

        int answer = 0;
        ArrayList<String> openedWords = new ArrayList<>();

        for (int rangeNum = 0; rangeNum < spoiler_ranges.length; rangeNum++) {
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);

                if (openAt.get(i) == rangeNum) {
                    if (normalWords.contains(word)) {
                        continue;
                    }

                    if (openedWords.contains(word)) {
                        continue;
                    }

                    openedWords.add(word);
                    answer++;
                }
            }
        }
        return answer;
    }
}