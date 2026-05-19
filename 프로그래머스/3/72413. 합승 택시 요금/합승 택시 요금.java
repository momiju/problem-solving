import java.util.*;
class Solution {
    static final int INF = 20000001;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n + 1][n + 1];

        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = INF;
            }
        }

        // 자기 자신까지의 거리 0
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        // 요금 정보 넣기
        for (int i = 0; i < fares.length; i++) {
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];

            graph[c][d] = f;
            graph[d][c] = f;
        }

        // 다익스트라
        int[] startDist = dijkstra(n, s, graph);
        int[] aDist = dijkstra(n, a, graph);
        int[] bDist = dijkstra(n, b, graph);

        int answer = INF;

        // i번 지점에서 헤어진다고 가정
        for (int i = 1; i <= n; i++) {
            int total = startDist[i] + aDist[i] + bDist[i];

            if (total < answer) {
                answer = total;
            }
        }
        return answer;
    }

    public int[] dijkstra(int n, int start, int[][] graph) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        // 거리 배열 초기화
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }

        // 시작 지점은 0
        dist[start] = 0;

        // 모든 지점을 한 번씩 확인
        for (int i = 1; i <= n; i++) {
            int minIndex = -1;
            int minValue = INF;

            // 아직 방문하지 않은 지점 중 가장 가까운 지점 찾기
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && dist[j] < minValue) {
                    minValue = dist[j];
                    minIndex = j;
                }
            }

            // 더 이상 갈 수 있는 지점이 없으면 종료
            if (minIndex == -1) {
                break;
            }

            visited[minIndex] = true;

            // minIndex를 거쳐서 다른 지점으로 가는 비용 갱신
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && graph[minIndex][j] != INF) {
                    if (dist[j] > dist[minIndex] + graph[minIndex][j]) {
                        dist[j] = dist[minIndex] + graph[minIndex][j];
                    }
                }
            }
        }

        return dist;
    }
}