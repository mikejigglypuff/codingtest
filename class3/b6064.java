package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b6064 {
  public static int gcd(int n, int m) {
    if(m == 0) { return n; }
    else {
      return gcd(m, n % m);
    }
  }

  public static int Inka(int x, int y, int m, int n, int max_num) {
    for(int i = y; i <= max_num; i+=n) {
      if(i % m == x) {
        return i;
      }
      else if(i % m == 0 && x == m) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try{
      int t = Integer.parseInt(br.readLine());

      for(int i = 0; i < t; i++) {
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);
        int y = Integer.parseInt(input[3]);
        int max_num = m * n / gcd(Math.max(m, n), Math.min(m, n));

        System.out.println(Inka(x, y, m, n, max_num));
      }

    } catch (IOException e) {}
  }
}
