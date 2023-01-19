package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b2667 {
  public static String[] graph;
  public static boolean[][] visited;
  public static int complex;

  public static ArrayList<Integer> put_num(int n) {
    ArrayList<Integer> result = new ArrayList<>();
    int square = (int)Math.pow(n, 2), i, x, y, cur_x, cur_y, count;

    for(i = 0; i < square; i++) {
      count = 1;
      x = i % n; y = i / n;
      if(visited[y][x] || graph[y].charAt(x) == '0') { continue; }

      visited[y][x] = true;
      Queue<int[]> queue = new LinkedList<>();
      queue.add(new int[] {x, y});

      while (!queue.isEmpty()) {
        int[] cur = queue.remove();
        Queue<int[]> next = new LinkedList<>();
        cur_x = cur[0]; cur_y = cur[1];
        if(cur_x > 0 && !visited[cur_y][cur_x - 1] && graph[cur_y].charAt(cur_x - 1) == '1') {
          visited[cur_y][cur_x - 1] = true;
          next.add(new int[]{cur_x - 1, cur_y});
          count++;
        }
        if(cur_x < n - 1 && !visited[cur_y][cur_x + 1] && graph[cur_y].charAt(cur_x + 1) == '1') {
          visited[cur_y][cur_x + 1] = true;
          next.add(new int[]{cur_x + 1, cur_y});
          count++;
        }
        if(cur_y > 0 && !visited[cur_y - 1][cur_x] && graph[cur_y - 1].charAt(cur_x) == '1') {
          visited[cur_y - 1][cur_x] = true;
          next.add(new int[]{cur_x, cur_y - 1});
          count++;
        }
        if(cur_y < n - 1 && !visited[cur_y + 1][cur_x] && graph[cur_y + 1].charAt(cur_x) == '1') {
          visited[cur_y + 1][cur_x] = true;
          next.add(new int[]{cur_x, cur_y + 1});
          count++;
        }

        queue.addAll(next);
        next.clear();
      }
      result.add(count);
      complex++;
    }

    Collections.sort(result);
    return result;
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try{
      int n = Integer.parseInt(br.readLine());
      graph = new String[n];
      visited = new boolean[n][n];
      complex = 0;
      for(int i = 0; i < n; i++) {
        graph[i] = br.readLine();
      }

      ArrayList<Integer> arr = put_num(n);
      System.out.println(complex);
      for(int i : arr) {
        System.out.println(i);
      }

    } catch (IOException e) {}

  }
}
