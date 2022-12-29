package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1074 {
  public static int Z(int n, int r, int c) {
    int width = (int)Math.sqrt(n), divs = n / 4, result = 0, div_width = width / 2,
            x = 0, y = 0;

    while (width > 1) {
      if(c >= x + div_width) {
        x += div_width;
        result += divs;
      }
      if(r >= y + div_width) {
        y += div_width;
        result += divs * 2;
      }

      width /= 2;
      divs /= 4;
      div_width /= 2;
    }

    return result;
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      String[] input = br.readLine().split(" ");
      int n = Integer.parseInt(input[0]), r = Integer.parseInt(input[1]),
              c = Integer.parseInt(input[2]);

      System.out.println(Z((int)Math.pow(Math.pow(2, n), 2), r, c));

    } catch (IOException e) {}

  }
}
