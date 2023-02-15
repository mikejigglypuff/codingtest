package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b16236 {

  static int[][] graph;
  static boolean[][] visited;
  static int[] target;
  static int n, size, eats;
  static final Comparator<int[]> comp = new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
      if(o1[0] < o2[0]) {
        return -1;
      } else if(o1[0] == o2[0]) {
        if(o1[1] < o2[1]) {
          return -1;
        } else {
          return 1;
        }
      } else {
        return 1;
      }
    }
  };

  public static int bfs(int y, int x) {
    int count = 0;
    int[] cur;

    visited[y][x] = true;
    PriorityQueue<int[]> queue = new PriorityQueue<>(comp);
    PriorityQueue<int[]> next = new PriorityQueue<>(comp);
    queue.add(new int[]{y, x});

    while (!queue.isEmpty()) {
      while (!queue.isEmpty()) {
        cur = queue.remove();

        if(graph[cur[0]][cur[1]] > 0 && graph[cur[0]][cur[1]] < size
                && graph[cur[0]][cur[1]] < 7) {
          target = new int[]{cur[0], cur[1]};
          ++eats;
          if(eats >= size) {
            ++size;
            eats = 0;
          }
          return count;
        }

        if(cur[0] > 0 && graph[cur[0] - 1][cur[1]] <= size &&
                !visited[cur[0] - 1][cur[1]]) {
          visited[cur[0] - 1][cur[1]] = true;
          next.add(new int[]{cur[0] - 1, cur[1]});
        }
        if(cur[1] > 0 && graph[cur[0]][cur[1] - 1] <= size &&
                !visited[cur[0]][cur[1] - 1]) {
          visited[cur[0]][cur[1] - 1] = true;
          next.add(new int[]{cur[0], cur[1] - 1});
        }
        if(cur[1] < n - 1 && graph[cur[0]][cur[1] + 1] <= size &&
                !visited[cur[0]][cur[1] + 1]) {
          visited[cur[0]][cur[1] + 1] = true;
          next.add(new int[]{cur[0], cur[1] + 1});
        }
        if(cur[0] < n - 1 && graph[cur[0] + 1][cur[1]] <= size &&
                !visited[cur[0] + 1][cur[1]]) {
          visited[cur[0] + 1][cur[1]] = true;
          next.add(new int[]{cur[0] + 1, cur[1]});
        }
      }

      queue.addAll(next);
      next.clear();
      count++;
    }

    return 0;
  }

  public static int eat(int y, int x) {

    int result = 0;
    int b;

    do {
      visited = new boolean[n][n];
      b = bfs(y, x);
      result += b;

      graph[y][x] = 0;
      try {
        y = target[0];
        x = target[1];
        graph[y][x] = 9;
      } catch (Exception e) {
        break;
      }
    } while (b != 0);

    return result;
  }

  public static void main(String[] Args) {


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try{
      n = Integer.parseInt(br.readLine());
      size = 2;
      eats = 0;
      graph = new int[n][];

      for(int i = 0; i < n; i++) {
        graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      }

      int y = 0, x = 0;
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
          if(graph[i][j] == 9) {
            y = i; x = j;
          }
        }
      }

      System.out.println(eat(y, x));

    } catch (IOException e) {}

  }
}
