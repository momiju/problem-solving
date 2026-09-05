class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        String[] weekdays = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] monthDays = {31,29,31,30,31,30,31,31,30,31,30,31};
        
        for(int i=0;i<a-1;i++){
            b += monthDays[i];
        }
        
        answer = weekdays[(b+4) % 7];
        
        return answer;
    }
}