package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b11726 {

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      int n = Integer.parseInt(br.readLine());
      ArrayList<Integer> dp = new ArrayList<Integer>(List.of(0, 1, 2));
      int i;
      for(i = 3; i <= n; i++) {
        dp.add((dp.get(i - 1) + dp.get(i - 2)) % 10007);
      }

      System.out.println(dp.get(n));

    } catch (IOException e) {}
  }
}