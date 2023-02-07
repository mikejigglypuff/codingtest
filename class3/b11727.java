package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b11727 {

  static int[] dp;

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try{
      int n = Integer.parseInt(br.readLine());
      dp = new int[n + 1];
      dp[0] = 0;
      if(n > 0) {
        dp[1] = 1;
      }
      if(n > 1) {
        dp[2] = 3;
      }
      for(int i = 3; i <= n; i++) {
        dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
      }

      System.out.println(dp[n]);

    } catch (IOException e) {}
  }
}