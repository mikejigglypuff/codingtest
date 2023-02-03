package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b11403 {
  static char[][] graph;
  static boolean[][] visited;

  public static void bfs(int n) {
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> next = new LinkedList<>();

    for(int i = 0; i < n; i++) {
      queue.add(i);

      while (!queue.isEmpty()) {
        while (!queue.isEmpty()) {
          int cur = queue.remove();

          for(int j = 0; j < n; j++) {
            if(graph[cur][j] == '1' && !visited[i][j]){
              next.add(j);
              visited[i][j] = true;
            }
          }
        }

        queue.addAll(next);
        next.clear();
      }
    }
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try{
      int n = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();
      graph = new char[n][];
      visited = new boolean[n][n];

      for(int i = 0; i < n; i++) {
        graph[i] = br.readLine().replace(" ", "").toCharArray();
      }

      bfs(n);

      for(boolean[] i : visited) {
        for(boolean j : i) {
          sb.append(j ? "1 " : "0 ");
        }
        sb.append("\n");
      }

      System.out.println(sb);

    } catch (IOException e) {}
  }
}
