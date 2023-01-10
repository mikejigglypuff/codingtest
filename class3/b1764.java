package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1764 {

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      String[] input = br.readLine().split(" ");
      int n = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);
      HashMap<String, Boolean> nohear = new HashMap<String, Boolean>();
      ArrayList<String> noseehear = new ArrayList<String>();
      StringBuilder sb = new StringBuilder();

      int i; String name;
      for(i = 0; i < n; i++) {
        name = br.readLine();
        nohear.put(name, true);
      }

      for(i = 0; i < m; i++) {
        name = br.readLine();
        try {
          if(nohear.get(name)) {
            noseehear.add(name);
          }
        } catch (NullPointerException e) {
          continue;
        }
      }

      Collections.sort(noseehear);
      sb.append(noseehear.size() + "\n");

      for(String s : noseehear) {
        sb.append(s + "\n");
      }
      System.out.println(sb);

    } catch (IOException e) {}

  }
}