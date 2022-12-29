package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b1107 {
  static int button_min = 500000, len_button = 10, channel = 0;
  static final int max_input = 500000, cur = 100;
  static ArrayList<Integer> buttons = new ArrayList<Integer>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

  public static void remocon(int n, int digit) {
    if(digit > Math.log10(max_input) + 1) { return; }
    int nums_count = (int)Math.pow(len_button, digit);

    int i, j, comp = 0, x, diff;
    for(i = 0; i < nums_count; i++) {
      comp = 0;
      x = i;

      for(j = 0; j < digit; j++) {
        comp += (int)Math.pow(10, j) * buttons.get(x % len_button);
        x /= len_button;
      }
      diff = Math.abs(n - comp);
      if(button_min > diff) {
        button_min = diff;
        channel = comp;
      }

    }
    remocon(n, ++digit);
  }

  public static void main(String[] Args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());

      if(m > 0) {
        String[] input = br.readLine().split(" ");

        int[] brokes = new int[m];
        int i;
        for (i = 0; i < m; i++) {
          brokes[i] = Integer.parseInt(input[i]);
        }

        for(int j = 0; j < m; j++) {
          buttons.remove((Integer)brokes[j]);
        }
        len_button -= m;

      }

      remocon(n, 1);

      if(channel != 0) {
        System.out.println((int)Math.min(Math.floor(Math.log10(channel)) + 1 + button_min, Math.abs(n - cur)));
      }
      else {
        System.out.println((int)Math.min(button_min + 1, Math.abs(n - cur)));
      }


    } catch (IOException e) {}
  }
}
