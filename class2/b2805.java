package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class b2805 {
  public static int[] Merge_Sort(int n, int[] ncard) {
    if(n <= 1) { return ncard; }

    int x = n / 2, y = n - x;

    int[] div1 = Merge_Sort(x, Arrays.copyOfRange(ncard, 0, x));
    int[] div2 = Merge_Sort(y, Arrays.copyOfRange(ncard, x, n));

    return Merge(div1, div2, x, y);

  }

  public static int[] Merge(int[] div1, int[] div2,
                            int len1, int len2) {
    int i = 0, j = 0, d1 = 0, d2 = 0;
    int[] result = new int[len1 + len2];

    while (i < len1 && j < len2) {
      d1 = div1[i];
      d2 = div2[j];
      if(d1 <= d2){
        result[i + j] = d1;
        i++;
      }
      else {
        result[i + j] = d2;
        j++;
      }
    }

    while(i < len1) {
      result[i + j] = div1[i];
      i++;
    }
    while(j < len2) {
      result[i + j] = div2[j];
      j++;
    }

    return result;
  }

  public static int tree_binary_search(int n, int m, int[] trees) {
    int start = 0, end = trees[n - 1];
    int mid = (start + end) / 2;
    long sum;
    int i;
    while (mid != start && mid != end) {
      sum = 0;
      for(i = n - 1; i > -1; i--) {
        if(trees[i] > mid) {
          sum += trees[i] - mid;
        }
      }
      if(sum >= m) {
        start = mid;
      }
      else {
        end = mid;
      }
      mid = (start + end) / 2;
    }

    return mid;
  }

  public static void main(String[] Args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m;

    try {
      String[] input = br.readLine().split(" ");
      n = Integer.parseInt(input[0]);
      m = Integer.parseInt(input[1]);
      input = br.readLine().split(" ");
      int[] trees = Stream.of(input).mapToInt(Integer::parseInt).toArray();
      trees = Merge_Sort(n, trees);
      System.out.println(tree_binary_search(n, m, trees));


    } catch (IOException e) {}
  }
}
