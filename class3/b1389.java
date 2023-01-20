package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1389 {
  static int n, m, bacon_min = 500000, min_user = 101;
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> graph;

  public static void bfs(int start, ArrayList<Integer> nodes, int depth, int bacon) {
    if(nodes.size() == 0) {
      if(bacon < bacon_min) {
        bacon_min = bacon;
        min_user = start;
      }
      else if(bacon_min == bacon && start < min_user) {
        min_user = start;
      }
      return;
    }

    ArrayList<Integer> next = new ArrayList<Integer>();
    for(int i: nodes) {
      if(!visited[i]) {
        visited[i] = true;
        bacon += depth;

        for(int j : graph.get(i)) {
          if(!visited[j]) {
            next.add(j);
          }
        }
      }
    }
    bfs(start, next, ++depth, bacon);
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      String[] input = br.readLine().split(" ");
      n = Integer.parseInt(input[0]);
      m = Integer.parseInt(input[1]);
      graph = new ArrayList<ArrayList<Integer>>(n + 1);
      visited = new boolean[n + 1];

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
        bfs(i, new ArrayList<Integer>(List.of(i)), 0, 0);
        visited = new boolean[n + 1];
      }

      System.out.println(min_user);

    } catch (IOException e) {}

  }
}