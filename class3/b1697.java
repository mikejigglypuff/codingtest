package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1697 {
  static int n, k;
  static boolean[] visited;

  public static int Hide_And_Seek() {
    int depth = 1, min = Math.abs(k - n), cur;
    int plus, minus, mul;
    Queue<Integer> queue = new LinkedList<Integer>(List.of(n - 1, n + 1, n * 2));
    Queue<Integer> temp_queue = new LinkedList<Integer>();
    while (true) {
      if(depth >= min) { return depth; }
      temp_queue.clear();

      while (!queue.isEmpty()) {
        cur = queue.remove();

        if(cur == k) {
          return depth;
        }
        else if(cur > k) {
          min = (cur - k < min - depth) ? depth + cur - k : min;
        }
        else if(cur >= 0) {
          plus = cur + 1;
          minus = cur - 1;
          mul = cur * 2;

          if(minus > 0 && !visited[minus]) {
            temp_queue.add(minus);
            visited[minus] = true;
          }
          if(mul <= k && !visited[mul]) {
            temp_queue.add(mul);
            visited[mul] = true;
          }
          else if(mul > k) {
            temp_queue.add(mul);
          }
          if(plus <= k && !visited[plus]) {
            temp_queue.add(plus);
            visited[plus] = true;
          }
        }
      }

      queue.addAll(temp_queue);
      if(queue.isEmpty()) { return depth; }
      depth++;
    }
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      String[] input = br.readLine().split(" ");
      n = Integer.parseInt(input[0]);
      k = Integer.parseInt(input[1]);
      visited = new boolean[k + 1];
      if(n < k) {
        visited[n] = true;
        System.out.println(Hide_And_Seek());
      }
      else {
        System.out.println(n - k);
      }

    } catch (IOException e) {}

  }
}
