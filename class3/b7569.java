package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b7569 {
  static String[][][] graph;
  static boolean[][][] visited;
  static int n, m, h;

  public static int calc() {
    Queue<int[]> queue = new LinkedList<>();
    Queue<int[]> next = new LinkedList<>();
    int result = 0;

    for(int i = 0; i < h; i++) {
      for(int j = 0; j < n; j++) {
        for(int k = 0; k < m; k++) {
          if(graph[i][j][k].equals("1")) {
            queue.add(new int[]{i, j, k});
          }
        }
      }
    }

    while (true) {
      while (!queue.isEmpty()) {
        int[] cur = queue.remove();
        int x = cur[2], y = cur[1], z = cur[0];

        if(x > 0 && !visited[z][y][x - 1] && graph[z][y][x - 1].equals("0")) {
          next.add(new int[]{z, y, x - 1});
          visited[z][y][x - 1] = true;
          graph[z][y][x - 1] = "1";
        }
        if(x < m - 1 && !visited[z][y][x + 1] && graph[z][y][x + 1].equals("0")) {
          next.add(new int[]{z, y, x + 1});
          visited[z][y][x + 1] = true;
          graph[z][y][x + 1] = "1";
        }
        if(y > 0 && !visited[z][y - 1][x] && graph[z][y - 1][x].equals("0")) {
          next.add(new int[]{z, y - 1, x});
          visited[z][y - 1][x] = true;
          graph[z][y - 1][x] = "1";
        }
        if(y < n - 1 && !visited[z][y + 1][x] && graph[z][y + 1][x].equals("0")) {
          next.add(new int[]{z, y + 1, x});
          visited[z][y + 1][x] = true;
          graph[z][y + 1][x] = "1";
        }
        if(z > 0 && !visited[z - 1][y][x] && graph[z - 1][y][x].equals("0")) {
          next.add(new int[]{z - 1, y, x});
          visited[z - 1][y][x] = true;
          graph[z - 1][y][x] = "1";
        }
        if(z < h - 1 && !visited[z + 1][y][x] && graph[z + 1][y][x].equals("0")) {
          next.add(new int[]{z + 1, y, x});
          visited[z + 1][y][x] = true;
          graph[z + 1][y][x] = "1";
        }

      }
      queue.addAll(next);
      next.clear();

      if(queue.isEmpty()) {
        return completed() ? result : -1;
      }

      result++;
    }
  }

  public static boolean completed() {
    for(String[][] i : graph) {
      for(String[] j : i) {
        for(String k : j) {
          if(k.equals("0")) { return false; }
        }
      }
    }
    return true;
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try{
      String[] input = br.readLine().split(" ");
      m = Integer.parseInt(input[0]);
      n = Integer.parseInt(input[1]);
      h = Integer.parseInt(input[2]);
      graph = new String[h][n][m];
      visited = new boolean[h][n][m];

      for(int i = 0; i < h; i++) {
        for(int j = 0; j < n; j++) {
          graph[i][j] = br.readLine().split(" ");
        }
      }

      System.out.println(calc());

    } catch (IOException e) {}
  }
}
