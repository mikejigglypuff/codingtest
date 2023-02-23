package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b16928 {

  static final int START = 1, GOAL = 100;
  static HashMap<Integer, Integer> ladder, snake;
  static boolean[] visited;

  public static int bfs() {
    int count = 0, cur;

    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> next = new LinkedList<>();
    queue.add(START);
    visited[START] = true;

    while (true) {
      while (!queue.isEmpty()) {
        cur = queue.poll();
        if(cur == GOAL) { return count; }

        for(int i = 1; i <= 6; i++) {
          int move = cur + i;
          if(move > 100) { continue; }
          if(visited[move]) { continue; }

          if(ladder.containsKey(move)) {
            next.add(ladder.get(move));
            visited[ladder.get(move)] = true;
          }
          else if(snake.containsKey(move)) {
            next.add(snake.get(move));
            visited[snake.get(move)] = true;
          }
          else {
            next.add(move);
            visited[move] = true;
          }
        }
      }

      if(next.isEmpty()) { break; }

      queue.addAll(next);
      next.clear();
      count++;
    }

    return count;
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try{
      String[] input = br.readLine().split(" ");
      int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
      ladder = new HashMap<>(); snake = new HashMap<>();
      visited = new boolean[101];

      for(int i = 0; i < n + m; i++) {
        input = br.readLine().split(" ");
        if(i < n) {
          ladder.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }  else {
          snake.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
      }

      System.out.println(bfs());

    } catch (IOException e) {}

  }
}
