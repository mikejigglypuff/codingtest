package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b7662 {
  static StringBuilder sb;

  public static class Dual_Heap {
    private PriorityQueue<int[]> min_heap, max_heap;
    private boolean[] visited;
    private int id;

    Dual_Heap() {
      min_heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          return (o1[0] > o2[0]) ? 1 : -1;
        }
      });
      max_heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          return (o1[0] < o2[0]) ? 1 : -1;
        }
      });
      visited = new boolean[1000001];
      id = 0;
    }

    public void input(int n) {
      min_heap.add(new int[]{n, id});
      max_heap.add(new int[]{n, id});
      visited[id] = true;
      id++;
    }

    public void del_front() {
      while (!min_heap.isEmpty() && !visited[min_heap.peek()[1]]) {
        min_heap.remove();
      }

      if(!min_heap.isEmpty()) {
        visited[min_heap.peek()[1]] = false;
        min_heap.remove();
      }
    }

    public void del_back() {
      while (!max_heap.isEmpty() && !visited[max_heap.peek()[1]]) {
        max_heap.remove();
      }

      if(!max_heap.isEmpty()) {
        visited[max_heap.peek()[1]] = false;
        max_heap.remove();
      }
    }

    public void print() {
      while (!min_heap.isEmpty() && !visited[min_heap.peek()[1]]) {
        min_heap.remove();
      }
      while (!max_heap.isEmpty() && !visited[max_heap.peek()[1]]) {
        max_heap.remove();
      }

      if(!min_heap.isEmpty()) {
        sb.append(max_heap.peek()[0] + " " + min_heap.peek()[0] + "\n");
      }
      else {
        sb.append("EMPTY\n");
      }
    }
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      sb = new StringBuilder();
      int t = Integer.parseInt(br.readLine());

      for(int i = 0; i < t; i++) {
        int l = Integer.parseInt(br.readLine());
        Dual_Heap dual_heap = new Dual_Heap();
        for(int j = 0; j < l; j++) {
          String[] input = br.readLine().split(" ");
          String command = input[0];
          int num = Integer.parseInt(input[1]);

          if(command.equals("I")) {
            dual_heap.input(num);
          }
          else if(command.equals("D")) {
            if(num == 1) {
              dual_heap.del_back();
            }
            else {
              dual_heap.del_front();
            }
          }
        }
        dual_heap.print();
      }
      System.out.println(sb);

    } catch (IOException e) {}

  }
}