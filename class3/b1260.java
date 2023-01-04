package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1260 {
  static int n, m;
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> graph;

  public static void dfs(int start) {
    System.out.print(start + " ");
    visited[start] = true;

    for(int num : graph.get(start)) {
      if(!visited[num]) {
        dfs(num);
      }
    }
  }

  public static void bfs(int start) {
    Deque<Integer> queue = new LinkedList<Integer>();
    visited[start] = true;
    queue.addLast(start);

    int cur;
    while (!queue.isEmpty()) {
      cur = queue.removeFirst();
      System.out.print(cur + " ");
      for(int num : graph.get(cur)) {
        if(!visited[num]) {
          queue.addLast(num);
          visited[num] = true;
        }
      }
    }
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      String[] input = br.readLine().split(" ");
      n = Integer.parseInt(input[0]);
      m = Integer.parseInt(input[1]);
      int start = Integer.parseInt(input[2]);
      visited = new boolean[n + 1];
      graph = new ArrayList<ArrayList<Integer>>(n + 1);

      int i, x, y;
      for(i = 0; i <= n; i++) {
        graph.add(new ArrayList<Integer>());
      }

      for(i = 0; i < m; i++) {
        input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        graph.get(x).add(y);
        graph.get(y).add(x);
      }

      for(i = 1; i <= n; i++) {
        Collections.sort(graph.get(i));
      }

      dfs(start);
      System.out.println();
      visited = new boolean[n + 1];
      bfs(start);

    } catch (IOException e) {}

  }
}
