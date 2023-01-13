package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b7576 {
  static int days, n, m;
  static String[][] tomatos;
  static boolean[][] visited;

  public static ArrayList<ArrayList<Integer>> get_start() {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(tomatos[i][j].equals("1")) {
          result.add(new ArrayList<Integer>(List.of(i, j)));
        }
      }
    }

    return result;
  }

  public static void ripen(ArrayList<ArrayList<Integer>> rtomatos) {
    int day = -1, x, y;
    ArrayList<ArrayList<Integer>> next = new ArrayList<ArrayList<Integer>>();

    while (!rtomatos.isEmpty()) {
      for(ArrayList<Integer> i : rtomatos) {
        x = i.get(1); y = i.get(0);

        if(x > 0 && tomatos[y][x - 1].equals("0") && !visited[y][x - 1]) {
          tomatos[y][x - 1] = "1";
          visited[y][x - 1] = true;
          next.add(new ArrayList<Integer>(List.of(y, x - 1)));
        }
        if(x < m - 1 && tomatos[y][x + 1].equals("0") && !visited[y][x + 1]) {
          tomatos[y][x + 1] = "1";
          visited[y][x + 1] = true;
          next.add(new ArrayList<Integer>(List.of(y, x + 1)));
        }
        if(y > 0 && tomatos[y - 1][x].equals("0") && !visited[y - 1][x]) {
          tomatos[y - 1][x] = "1";
          visited[y - 1][x] = true;
          next.add(new ArrayList<Integer>(List.of(y - 1, x)));
        }
        if(y < n - 1 && tomatos[y + 1][x].equals("0") && !visited[y + 1][x]) {
          tomatos[y + 1][x] = "1";
          visited[y + 1][x] = true;
          next.add(new ArrayList<Integer>(List.of(y + 1, x)));
        }
      }
      rtomatos.clear();
      rtomatos.addAll(next);
      next.clear();
      day++;
    }

    days = (completed()) ? day : -1;
  }

  public static boolean completed() {
    for(String[] i : tomatos) {
      for(String j : i) {
        if(j.equals("0")) { return false; }
      }
    }
    return true;
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      String[] input = br.readLine().split(" ");
      m = Integer.parseInt(input[0]); n = Integer.parseInt(input[1]);
      visited = new boolean[n][m];
      tomatos = new String[n][m];
      days = -1;

      for(int i = 0; i < n; i++) {
        tomatos[i] = br.readLine().split(" ");
      }

      ripen(get_start());
      System.out.println(days);

    } catch (IOException e) {}

  }
}
