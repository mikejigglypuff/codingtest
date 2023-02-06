package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class b11659 {
  static int[] nums;
  static int[] sums;

  public static void fill_sums(int n) {
    sums[0] = 0;
    for(int i = 0; i < n; i++) {
      sums[i + 1] = sums[i] + nums[i];
    }
  }

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try{
      String[] input = br.readLine().split(" ");
      int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
      input = br.readLine().split(" ");
      nums = Stream.of(input).mapToInt(Integer::parseInt).toArray();
      sums = new int[n + 1];

      fill_sums(n);

      int start, end;
      while (m-- > 0) {
        input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);
        System.out.println(sums[end] - sums[start - 1]);
      }

    } catch (IOException e) {}
  }
}
