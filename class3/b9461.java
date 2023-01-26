package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9461 {

  public static void main(String[] Args) {
    long[] dp = new long[100];
    dp[0] = 1; dp[1] = 1; dp[2] = 1; dp[3] = 2; dp[4] = 2;
    for (int i = 5; i < 100; i++) {
      dp[i] = dp[i - 3] + dp[i - 2];
    }
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    try{
      int t = Integer.parseInt(br.readLine());
      while (t-- > 0) {
        sb.append(dp[Integer.parseInt(br.readLine()) - 1] + "\n");
      }
      System.out.println(sb);

    } catch (IOException e) {}
  }
}
