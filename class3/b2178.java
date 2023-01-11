package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b2178 {
  static int n, m, min;
  static boolean[][] visited;
  static String[] maze;

  public static void search() {
    int depth = 1;
    Queue<int[]> queue = new LinkedList<int[]>();

    int l, x, y; int[] cur; Queue<int[]> next = new LinkedList<int[]>();
    queue.add(new int[]{0, 0});
    while(!queue.isEmpty()) {
      l = queue.size();
      next.clear();

      for(int i = 0; i < l; i++) {
        cur = queue.remove();
        x = cur[0]; y = cur[1];

        if(x == m - 1 && y == n - 1 && min > depth) {
          min = depth;
          return;
        }

        if(x > 0 && !visited[y][x - 1] && maze[y].charAt(x - 1) == '1') {
          next.add(new int[]{x - 1, y});
          visited[y][x - 1] = true;
        }
        if(x < m - 1 && !visited[y][x + 1] && maze[y].charAt(x + 1) == '1') {
          next.add(new int[]{x + 1, y});
          visited[y][x + 1] = true;
        }
        if(y > 0 && !visited[y - 1][x] && maze[y - 1].charAt(x) == '1') {
          next.add(new int[]{x, y - 1});
          visited[y - 1][x] = true;
        }
        if(y < n - 1 && !visited[y + 1][x] && maze[y + 1].charAt(x) == '1') {
          next.add(new int[]{x, y + 1});
          visited[y + 1][x] = true;
        }
      }

      depth++;
      queue.addAll(next);
    }
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      String[] input = br.readLine().split(" ");
      n = Integer.parseInt(input[0]);
      m = Integer.parseInt(input[1]);
      min = n * m;
      visited = new boolean[n][m];
      visited[0][0] = true;
      maze = new String[n];

      int i;
      for(i = 0; i < n; i++) {
        maze[i] = br.readLine();
      }

      search();
      System.out.println(min);

    } catch (IOException e) {}

  }
}
