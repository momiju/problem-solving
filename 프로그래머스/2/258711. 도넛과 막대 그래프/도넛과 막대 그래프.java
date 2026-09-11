class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int[] inDegree = new int[1000001];
        int[] outDegree = new int[1000001];
        
        for(int i=0;i<edges.length;i++){
            outDegree[edges[i][0]]++;
            inDegree[edges[i][1]]++;
        }
        
        for(int i=1;i<=1000000;i++){
            if(inDegree[i]==0 && outDegree[i]>=2){
                answer[0] = i;
            }
            
            if(outDegree[i]==0 && inDegree[i]>0){
                answer[2]++;
            }
            
            if(inDegree[i]>=2 && outDegree[i]==2){
                answer[3]++;
            }
        }
        
        answer[1] = outDegree[answer[0]]-answer[2]-answer[3];
        
        return answer;
    }
}