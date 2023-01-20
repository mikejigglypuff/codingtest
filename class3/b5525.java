package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b5525 {
  public static int IOIOI(int n, int m, String s) {
    int i = 0, result = 0, count = 0;

    for(i = 1; i < m - 1; i++) {
      if(s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
        count++;

        if(count == n) {
          result++;
          count--;
        }
        i++;
      }
      else {
        count = 0;
      }
    }

    return result;
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try{
      int n = Integer.parseInt(br.readLine());

      int m = Integer.parseInt(br.readLine());
      String input = br.readLine();

      System.out.println(IOIOI(n, m, input));

    } catch (IOException e) {}

  }
}
