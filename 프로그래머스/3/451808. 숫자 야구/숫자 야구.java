import java.util.function.Function;
import java.util.*;

class Solution {
    public int solution(int n, Function<Integer, String> submit) {
        List<Integer> candidates = new ArrayList<>();
        
        for(int num = 1234; num <= 9876; num++) {
            String s = String.valueOf(num);

            if(s.contains("0")) {
                continue;
            }

            boolean duplicate = false;

            for(int i = 0; i < 4; i++) {
                for(int j = i + 1; j < 4; j++) {
                    if(s.charAt(i) == s.charAt(j)) {
                        duplicate = true;
                    }
                }
            }

            if(!duplicate) {
                candidates.add(num);
            }
        }

        while(candidates.size() > 1) {
            int guess = candidates.get(0);
            String result = submit.apply(guess);

            if(result.equals("4S 0B"))
                return guess;

            List<Integer> next = new ArrayList<>();

            for(int candidate : candidates) {
                String secret = String.valueOf(candidate);
                String g = String.valueOf(guess);

                int strike = 0;
                int ball = 0;

                for(int i = 0; i < 4; i++) {

                    if(secret.charAt(i) == g.charAt(i)) {
                        strike++;
                    } else if(secret.indexOf(g.charAt(i)) != -1) {
                        ball++;
                    }
                }

                String checkResult = strike + "S " + ball + "B";

                if(checkResult.equals(result))
                    next.add(candidate);
            }
            candidates = next;
        }
        return candidates.get(0);
    }
}