package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1927 {

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
      int n = Integer.parseInt(br.readLine());
      int i, num;
      for(i = 0; i < n; i++) {
        num = Integer.parseInt(br.readLine());
        if(num == 0) {
          if(queue.isEmpty()) {
            System.out.println(0);
          }
          else {
            System.out.println(queue.poll());
          }
        }
        else {
          queue.add(num);
        }
      }

    } catch (IOException e) {}

  }
}
