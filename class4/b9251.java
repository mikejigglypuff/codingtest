/*
package class4;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        System.out.println(lcs(s1, s2));
    }

    public static int lcs(char[] s1, char[] s2) {
        int len1 = s1.length, len2 = s2.length, max = 0;

        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 0; i <= len1; i++) {
            for(int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
                else if(s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return max;
    }
}
 */