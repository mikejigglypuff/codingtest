package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class b2630 {
  public static int zero, one;

  public static ArrayList<Integer>[] div(int n, ArrayList<Integer> paper) {
    int half = n / 2, target = 0, i, w, h, len_paper = paper.size();
    ArrayList<Integer>[] result = new ArrayList[4];
    for(i = 0; i < 4; i++) {
      result[i] = new ArrayList<>();
    }

    for(i = 0; i < len_paper; i++) {
      w = i % n; h = i / n;
      if(w < half) {
        if(h >= half) {
          target = 2;
        }
        else {
          target = 0;
        }
      }
      else {
        if(h >= half) {
          target = 3;
        }
        else {
          target = 1;
        }
      }
      result[target].add(paper.get(i));
    }

    return result;
  }

  public static void div_con(int n, ArrayList<Integer> paper) {
    int blue = 0, white = 0, len_paper = paper.size(),
            square = (int)Math.pow(n, 2), i;

    for(i = 0; i < len_paper; i++) {
      if(paper.get(i) == 1) {
        blue++;
      }
      else {
        white++;
      }
    }

    if(blue == square) {
      one++;
      return;
    }

    if(white == square) {
      zero++;
      return;
    }

    int m = n / 2;
    ArrayList<Integer>[] pieces = div(n, paper);
    div_con(m, pieces[0]);
    div_con(m, pieces[1]);
    div_con(m, pieces[2]);
    div_con(m, pieces[3]);
  }

  public static void main(String[] Args) {


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      int n = Integer.parseInt(br.readLine());
      ArrayList<Integer> paper = new ArrayList<>();
      String[] input;

      for(int i = 0; i < n; i++) {
        input = br.readLine().split(" ");
        int[] next = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> x = (ArrayList<Integer>) Arrays.stream(next).boxed().collect(Collectors.toList());
        paper.addAll(x);
      }

      div_con(n, paper);
      System.out.println(zero + "\n" + one);

    } catch (IOException e) {}

  }
}
