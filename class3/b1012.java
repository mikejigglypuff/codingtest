package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1012 {
  static int[][] cabbages, loc;

  public static int get_min_worm(int m, int n, int k) {
    int result = 0;
    int i, loc_x, loc_y, left, right, up, down, x, y;
    int[] pos;
    Deque<int[]> queue;

    for(i = 0; i < k; i++) {
      loc_x = loc[i][0];
      loc_y = loc[i][1];
      if(loc_x < 0 || loc_x > m - 1 || loc_y < 0 || loc_y > n - 1
              || cabbages[loc_x][loc_y] == 0) {
        continue;
      }

      queue = new LinkedList<int[]>();
      queue.addLast(loc[i]);
      left = 1; right = 1; up = 1; down = 1;
      while (queue.size() != 0) {
        pos = queue.removeFirst();
        x = pos[0]; y = pos[1];

        if(x >= 0 && x <= m - 1 && y >= 0 && y <= n - 1
                && cabbages[x][y] == 1) {
          cabbages[x][y] = 0;

          if(x > 0) {
            left = cabbages[x - 1][y];
          } else { left = 0; }
          if(x < m - 1) {
            right = cabbages[x + 1][y];
          } else { right = 0; }
          if(y > 0) {
            up = cabbages[x][y - 1];
          } else { up = 0; }
          if(y < n - 1) {
            down = cabbages[x][y + 1];
          } else { down = 0; }

          if(left == 1) { queue.addLast(new int[]{x - 1, y}); }
          if(right == 1) { queue.addLast(new int[]{x + 1, y}); }
          if(up == 1) { queue.addLast(new int[]{x, y - 1}); }
          if(down == 1) { queue.addLast(new int[]{x, y + 1}); }
        }
      }

      result++;
    }

    return result;
  }

  public static void main(String[] Args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      int t = Integer.parseInt(br.readLine());
      int i, j, m, n, k, x, y;

      for(i = 0; i < t; i++) {
        String[] mnk = br.readLine().split(" ");
        m = Integer.parseInt(mnk[0]);
        n = Integer.parseInt(mnk[1]);
        k = Integer.parseInt(mnk[2]);

        cabbages = new int[m][n];
        loc = new int[k][2];

        for(j = 0; j < k; j++) {
          String[] xy = br.readLine().split(" ");
          x = Integer.parseInt(xy[0]);
          y = Integer.parseInt(xy[1]);
          loc[j] = new int[]{x, y};
          cabbages[x][y] = 1;
        }

        System.out.println(get_min_worm(m, n, k));
      }
    } catch (IOException e) {}
  }
}
