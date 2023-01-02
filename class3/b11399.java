package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.util.Arrays.sort;


public class b11399 {

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      int n = Integer.parseInt(br.readLine());
      String[] input = br.readLine().split(" ");
      int[] nums = new int[n];
      int i, cur_sum = 0, result = 0;

      for(i = 0; i < n; i++) {
        nums[i] = Integer.parseInt(input[i]);
      }

      sort(nums);

      for(int num : nums) {
        cur_sum += num;
        result += cur_sum;
      }

      System.out.println(result);

    } catch (IOException e) {}
  }
}
