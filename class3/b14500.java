package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class b14500 {

  static int max;
  static int[][] papers;

  static final Map<String, int[]> hw = new HashMap<>() {{
    put("I", new int[]{4, 1});
    put("Ir", new int[]{1, 4});
    put("O", new int[]{2, 2});
    put("L", new int[]{3, 2});
    put("Lr", new int[]{2, 3});
    put("S", new int[]{3, 2});
    put("Sr", new int[]{2, 3});
    put("T", new int[]{2, 3});
    put("Tr", new int[]{3, 2});
  }};

  static final int[][] I = new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}};
  static final int[][] I90 = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}};
  static final int[][] O = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
  static final int[][] L = new int[][]{{0, 0}, {1, 0}, {2, 0}, {2, 1}};
  static final int[][] L90 = new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 0}};
  static final int[][] L180 = new int[][]{{0, 0}, {0, 1}, {1, 1}, {2, 1}};
  static final int[][] L270 = new int[][]{{0, 2}, {1, 0}, {1, 1}, {1, 2}};
  static final int[][] Lr = new int[][]{{0, 1}, {1, 1}, {2, 0}, {2, 1}};
  static final int[][] Lr90 = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
  static final int[][] Lr180 = new int[][]{{0, 0}, {0, 1}, {1, 0}, {2, 0}};
  static final int[][] Lr270 = new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 2}};
  static final int[][] S = new int[][]{{0, 0}, {1, 0}, {1, 1}, {2, 1}};
  static final int[][] S90 = new int[][]{{0, 1}, {0, 2}, {1, 0}, {1, 1}};
  static final int[][] Sr = new int[][]{{0, 1}, {1, 0}, {1, 1}, {2, 0}};
  static final int[][] Sr90 = new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 2}};
  static final int[][] T = new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 1}};
  static final int[][] T90 = new int[][]{{0, 1}, {1, 0}, {1, 1}, {2, 1}};
  static final int[][] T180 = new int[][]{{0, 1}, {1, 0}, {1, 1}, {1, 2}};
  static final int[][] T270 = new int[][]{{0, 0}, {1, 0}, {1, 1}, {2, 0}};

  public static void Shape(int height, int width, int[][] shape) {
    int i, j, sum;
    for(i = 0; i < height; i++) {
      for(j = 0; j < width; j++) {
        sum = papers[i + shape[0][0]][j + shape[0][1]]
                + papers[i + shape[1][0]][j + shape[1][1]]
                + papers[i + shape[2][0]][j + shape[2][1]]
                + papers[i + shape[3][0]][j + shape[3][1]];
        max = (max < sum) ? sum : max;
      }
    }
  }

  public static void main(String[] Args) {


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try{
      String[] input = br.readLine().split(" ");
      int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);

      papers = new int[n][];
      for(int i = 0; i < n; i++) {
        papers[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      }

      max = 0;

      int[] cur = hw.get("I");
      Shape(n - cur[0] + 1, m - cur[1] + 1, I);

      cur = hw.get("Ir");
      Shape(n - cur[0] + 1, m - cur[1] + 1, I90);

      cur = hw.get("O");
      Shape(n - cur[0] + 1, m - cur[1] + 1, O);

      cur = hw.get("L");
      Shape(n - cur[0] + 1, m - cur[1] + 1, L);
      Shape(n - cur[0] + 1, m - cur[1] + 1, L180);
      Shape(n - cur[0] + 1, m - cur[1] + 1, Lr);
      Shape(n - cur[0] + 1, m - cur[1] + 1, Lr180);

      cur = hw.get("Lr");
      Shape(n - cur[0] + 1, m - cur[1] + 1, L90);
      Shape(n - cur[0] + 1, m - cur[1] + 1, L270);
      Shape(n - cur[0] + 1, m - cur[1] + 1, Lr90);
      Shape(n - cur[0] + 1, m - cur[1] + 1, Lr270);

      cur = hw.get("S");
      Shape(n - cur[0] + 1, m - cur[1] + 1, S);
      Shape(n - cur[0] + 1, m - cur[1] + 1, Sr);

      cur = hw.get("Sr");
      Shape(n - cur[0] + 1, m - cur[1] + 1, S90);
      Shape(n - cur[0] + 1, m - cur[1] + 1, Sr90);

      cur = hw.get("T");
      Shape(n - cur[0] + 1, m - cur[1] + 1, T);
      Shape(n - cur[0] + 1, m - cur[1] + 1, T180);

      cur = hw.get("Tr");
      Shape(n - cur[0] + 1, m - cur[1] + 1, T90);
      Shape(n - cur[0] + 1, m - cur[1] + 1, T270);

      System.out.println(max);

    } catch (IOException e) {}
  }
}
