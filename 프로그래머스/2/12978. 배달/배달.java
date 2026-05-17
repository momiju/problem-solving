class Solution {
    public int solution(int N, int[][] road, int K) {
        int INF = 50000001;

        // 1번 마을에서 각 마을까지의 최단 거리
        int[] dist = new int[N + 1];

        // 처음에는 모두 아주 큰 값으로 초기화
        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
        }

        // 시작점인 1번 마을까지의 거리는 0
        dist[1] = 0;

        // 벨만-포드는 최대 N-1번 반복하면 최단 거리가 확정됨
        for (int i = 1; i <= N - 1; i++) {

            // 모든 도로를 하나씩 확인
            for (int j = 0; j < road.length; j++) {
                int a = road[j][0];
                int b = road[j][1];
                int cost = road[j][2];

                // a -> b 방향 갱신
                if (dist[a] != INF && dist[a] + cost < dist[b]) {
                    dist[b] = dist[a] + cost;
                }

                // b -> a 방향 갱신
                // 문제에서 도로는 양방향이기 때문에 반대 방향도 확인해야 함
                if (dist[b] != INF && dist[b] + cost < dist[a]) {
                    dist[a] = dist[b] + cost;
                }
            }
        }

        // K 이하 시간 안에 배달 가능한 마을 개수 세기
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}