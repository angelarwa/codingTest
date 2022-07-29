//DFS - 인접 리스트 - 재귀함수
import java.util.*;

public class DFS_List {
    public static void main(String[] args) {
        // 그래프 표현
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수
        int v = sc.nextInt(); // 탐색을 시작할 정점의 번호

        boolean visited[] = new boolean[n + 1]; // 방문 여부를 검사할 배열
        
        LinkedList<Integer>[] adjList = new LinkedList[n + 1];
        
        for (int i = 0; i <= n; i++){ //두 정점 사이에 여러 개의 간선이 있을 수 있음. 입력으로 주어지는 간선은 양방향
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for (int i = 1; i <= n; i++){ 
            Collections.sort(adjList[i]); //방문 순서를 위해 오름차순 정렬
        }

        System.out.println("DFS - 인접리스트");
        dfs_list(v, adjList, c);

        public static void dfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited){
            visited[v] = true; //정점 방문 표시
            System.out.println(v + " "); //정점 출력

            Iterator<Integer> iter = adjList[v].listIterator(); //정점 인접리스트 순회
            while (iter.hasNext()){
                int w = iter.next();
                if (!visited[w]) //방문하지않은 정점이라면 다시 DFS
                    dfs_list(w, adjList, visited);
            }
        }

    }
}
