package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b10026 {
  static int n;
  static String[] graph;
  static boolean[][] visited;

  public static int normal() {
    int result = 0, square = (int)Math.pow(n, 2), y, x;
    char cur;
    Queue<int[]> queue = new LinkedList<>();
    visited = new boolean[n][n];

    for(int i = 0; i < square; i++) {
      y = i / n; x = i % n;
      if(visited[y][x]) { continue; }

      cur = graph[y].charAt(x);
      queue.add(new int[]{y, x});
      while (!queue.isEmpty()) {
        int[] pos = queue.remove();
        if(pos[0] > 0 && !visited[pos[0] - 1][pos[1]] &&
                graph[pos[0] - 1].charAt(pos[1]) == cur) {
          queue.add(new int[]{pos[0] - 1, pos[1]});
          visited[pos[0] - 1][pos[1]] = true;
        }
        if(pos[0] < n - 1 && !visited[pos[0] + 1][pos[1]] &&
                graph[pos[0] + 1].charAt(pos[1]) == cur) {
          queue.add(new int[]{pos[0] + 1, pos[1]});
          visited[pos[0] + 1][pos[1]] = true;
        }
        if(pos[1] > 0 && !visited[pos[0]][pos[1] - 1] &&
                graph[pos[0]].charAt(pos[1] - 1) == cur) {
          queue.add(new int[]{pos[0], pos[1] - 1});
          visited[pos[0]][pos[1] - 1] = true;
        }
        if(pos[1] < n - 1 && !visited[pos[0]][pos[1] + 1] &&
                graph[pos[0]].charAt(pos[1] + 1) == cur) {
          queue.add(new int[]{pos[0], pos[1] + 1});
          visited[pos[0]][pos[1] + 1] = true;
        }
      }

      result++;
    }

    return result;
  }

  public static int color_weakness() {
    int result = 0, square = (int)Math.pow(n, 2), y, x;
    char cur;
    Queue<int[]> queue = new LinkedList<>();
    visited = new boolean[n][n];

    for(int i = 0; i < square; i++) {
      y = i / n; x = i % n;
      if(visited[y][x]) { continue; }

      cur = graph[y].charAt(x);
      queue.add(new int[]{y, x});
      while (!queue.isEmpty()) {
        int[] pos = queue.remove();
        if(pos[0] > 0 && !visited[pos[0] - 1][pos[1]] &&
                color_weak_comp(cur, graph[pos[0] - 1].charAt(pos[1]))) {
          queue.add(new int[]{pos[0] - 1, pos[1]});
          visited[pos[0] - 1][pos[1]] = true;
        }
        if(pos[0] < n - 1 && !visited[pos[0] + 1][pos[1]] &&
                color_weak_comp(cur, graph[pos[0] + 1].charAt(pos[1]))) {
          queue.add(new int[]{pos[0] + 1, pos[1]});
          visited[pos[0] + 1][pos[1]] = true;
        }
        if(pos[1] > 0 && !visited[pos[0]][pos[1] - 1] &&
                color_weak_comp(cur, graph[pos[0]].charAt(pos[1] - 1))) {
          queue.add(new int[]{pos[0], pos[1] - 1});
          visited[pos[0]][pos[1] - 1] = true;
        }
        if(pos[1] < n - 1 && !visited[pos[0]][pos[1] + 1] &&
                color_weak_comp(cur, graph[pos[0]].charAt(pos[1] + 1))) {
          queue.add(new int[]{pos[0], pos[1] + 1});
          visited[pos[0]][pos[1] + 1] = true;
        }
      }

      result++;
    }

    return result;
  }

  public static boolean color_weak_comp(char color1, char color2) {
    if(color1 == color2) { return true; }
    else if(color1 != 'B' && color2 != 'B') { return true; }
    else { return false; }
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try{
      n = Integer.parseInt(br.readLine());
      graph = new String[n];

      for(int i = 0; i < n; i++) {
        graph[i] = br.readLine();
      }

      System.out.print(normal() + " " + color_weakness());

    } catch (IOException e) {}


  }
}
