
//DFS - 인접 행렬
import java.util.*;

public class DFS_List {
    public static void main(String[] args) {
        // 그래프 표현
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수
        int v = sc.nextInt(); // 탐색을 시작할 정점의 번호

        boolean visited[] = new boolean[n + 1]; // 방문 여부를 검사할 배열

        int[][] adjArray = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) { // 두 정점 사이에 여러 개의 간선이 있을 수 있음. 입력으로 주어지는 간선은 양방향
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjArray[v1][v2] = 1;
            adjArray[v2][v1] = 1;
        }

        System.out.println("DFS - 인접행렬 - 재귀");
        dfs_array_recursion(v, adjArray, visited);
        Arrays.fill(visited, false); // 스택 DFS를 위해 visited 배열 초기화

        System.out.println("DFS - 인접행렬 - 스택");
        dfs_array_stack(v, adjArray, visited, true);
    }

    public static void dfs_array_recursion(int v, int[][] adjArray, boolean[] visited) {
        int l = adjArray.length - 1;
        visited[v] = true; // 정점 방문 표시
        System.out.println(v + " "); // 정점 출력

        for (int i = 1; i <= 1; i++) {
            if (adjArray[v][i] == 1 && visited[i]) {
                dfs_array_recursion(i, adjArray, visited);
            }
        }
    }

    public static void dfs_array_stack(int v, int[][] adjArray, boolean[] visited, boolean flag) {
        int l = adjArray.length - 1;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(v);
        visited[v] = true; // 정점 방문 표시
        System.out.println(v + " "); // 정점 출력

        while(!stack.isEmpty()) {
            int w = stack.peek();
            flag = false;

            for(int i = 1; i <=l; i++){
                if(adjArray[w][i] == 1 && !visited[i]){
                    stack.push(i);
                    System.out.println(i + " ");
                    visited[i] = true;
                    flag = true;

                    break;
                }
            }
            if(!flag) 
                stack.pop();
        }
    }

}


