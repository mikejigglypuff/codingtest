package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class b11286 {

  public static void main(String[] Args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Integer> pos = new PriorityQueue<>();
    PriorityQueue<Integer> neg = new PriorityQueue<>(Collections.reverseOrder());
    StringBuilder sb = new StringBuilder();

    try{
      int n = Integer.parseInt(br.readLine()), x;

      for(int i = 0; i < n; i++) {
        x = Integer.parseInt(br.readLine());
        if(x > 0) {
          pos.add(x);
        } else if (x < 0) {
          neg.add(x);
        } else {
          if(pos.size() > 0 && neg.size() > 0){
            if(Math.abs(pos.peek()) < Math.abs(neg.peek())) {
              sb.append(pos.remove() + "\n");
            } else {
              sb.append(neg.remove() + "\n");
            }
          } else if (pos.size() > 0) {
            sb.append(pos.remove() + "\n");
          } else if (neg.size() > 0) {
            sb.append(neg.remove() + "\n");
          } else {
            sb.append("0\n");
          }
        }
      }

      System.out.println(sb);

    } catch (IOException e) {}

  }
}
