package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b2606 {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int result;

  public static void bfs(ArrayList<Integer> x) {
    if(x.isEmpty()) { return; }

    ArrayList<Integer> next = new ArrayList<Integer>();

    for(int i : x) {
      for(int j : graph[i]) {
        if(!visited[j]) {
          next.add(j);
          visited[j] = true;
        }
      }
    }

    result += next.size();
    bfs(next);
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      graph = new ArrayList[n + 1];
      visited = new boolean[n + 1];

      int i, x, y;
      for(i = 0; i <= n; i++) {
        graph[i] = new ArrayList<Integer>();
      }

      String[] input;
      for(i = 0; i < m; i++) {
        input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        graph[x].add(y);
        graph[y].add(x);
      }

      visited[1] = true;
      bfs(new ArrayList<Integer>(List.of(1)));
      System.out.println(result);

    } catch (IOException e) {}

  }
}