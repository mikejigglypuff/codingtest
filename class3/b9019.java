package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b9019 {
  static int b;
  static boolean[] visited;

  public static int D(int num) {
    return num * 2 % 10000;
  }

  public static int S(int num) {
    return (num != 0) ? num - 1 : 9999;
  }

  public static int L(int num) {
    int d = num / 1000;
    return num % 1000 * 10 + d;
  }

  public static int R(int num) {
    int d = num % 10;
    return num / 10 + d * 1000;
  }

  public static String bfs(HashMap<Integer, String> queue) {
    HashMap<Integer, String> next = new HashMap<>();
    int num, d, s, l, r;
    String comm;
    while (true) {
      for (Map.Entry<Integer, String> entry : queue.entrySet()) {
        num = entry.getKey(); comm = entry.getValue();
        if (num == b) { return comm; }

        d = D(num); s = S(num); l = L(num); r = R(num);
        if(!visited[d]) {
          next.put(d, comm + "D");
          visited[d] = true;
        }
        if(!visited[s]) {
          next.put(s, comm + "S");
          visited[s] = true;
        }
        if(!visited[l]) {
          next.put(l, comm + "L");
          visited[l] = true;
        }
        if(!visited[r]) {
          next.put(r, comm + "R");
          visited[r] = true;
        }
      }

      queue.clear();
      queue.putAll(next);
      next.clear();
    }
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try{
      int t = Integer.parseInt(br.readLine());
      for(int i = 0; i < t; i++) {
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);
        visited = new boolean[10001];

        System.out.println(bfs(new HashMap<>(){{
          put(a, "");
        }}));
      }

    } catch (IOException e) {}
  }
}
