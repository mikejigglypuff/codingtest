package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b11724 {

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      String[] input = br.readLine().split(" ");
      int i, j, k, n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), result = 0, x, y;
      int[][] graph = new int[n + 1][n + 1];
      boolean[] visited = new boolean[n + 1];
      Queue<Integer> queue, next;

      for(i = 0; i < m; i++) {
        input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        graph[x][y] = 1;
        graph[y][x] = 1;
      }

      for(i = 1; i <= n; i++) {
        if(visited[i]) { continue; }

        visited[i] = true;
        queue = new LinkedList<Integer>();

        for(j = 1; j <= n; j++) {
          if(!visited[j] && graph[i][j] == 1) {
            queue.add(j);
          }
        }

        while (!queue.isEmpty()) {
          next = new LinkedList<Integer>();

          for(int num : queue) {
            if(!visited[num]) {
              visited[num] = true;
              for(k = 1; k <= n; k++) {
                if(graph[num][k] == 1) {
                  next.add(k);
                }
              }
            }
          }
          queue = next;
        }
        result++;
      }
      System.out.println(result);

    } catch (IOException e) {}
  }
}
