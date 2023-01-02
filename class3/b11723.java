package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b11723 {

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      int m = Integer.parseInt(br.readLine());
      int set = 0, num = 0, i;
      StringBuilder sb = new StringBuilder();

      for(i = 0; i < m; i++) {
        String[] input = br.readLine().split(" ");

        switch (input[0]) {
          case "add":
            num = 1 << Integer.parseInt(input[1]);
            if((set & num) == 0) {
              set += num;
            }
            break;

          case "remove":
            num = 1 << Integer.parseInt(input[1]);
            if((set & num) == num) {
              set -= num;
            }
            break;

          case "check":
            num = 1 << Integer.parseInt(input[1]);
            if((set & num) == num) {
              sb.append("1\n");
            }
            else {
              sb.append("0\n");
            }
            break;

          case "toggle":
            num = 1 << Integer.parseInt(input[1]);
            if((set & num) == 0) {
              set += num;
            }
            else {
              set -= num;
            }
            break;

          case "all":
            set = (1 << 21) - 1;
            break;

          case "empty":
            set = 0;
            break;
        }
      }
      System.out.println(sb);

    } catch (IOException e) {}
  }
}