package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class b9095 {


  public static void main(String[] Args) {
    ArrayList<List<String>> dp = new ArrayList<List<String>>();
    dp.add(new ArrayList<String>(List.of("0")));
    dp.add(new ArrayList<String>(List.of("1")));
    for(int i = 2; i < 11; i++) {
      ArrayList<String> s = new ArrayList<String>();
      for(int j = 1; j < i; j++) {
        int n = i - j, lj = dp.get(j).size(), ln = dp.get(n).size();
        if(i <= 3) {
          s.add(Integer.toString(i));
        }
        if(n <= 3 && j <= 3) {
          s.add(Integer.toString(j) + n);
        }

        for(int k = 0; k < lj; k++) {
          for(int l = 0; l < ln; l++) {
            s.add(dp.get(j).get(k) + dp.get(n).get(l));
          }
        }
      }
      dp.add(s.parallelStream().distinct().collect(Collectors.toList()));
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      int t = Integer.parseInt(br.readLine());
      for(int i = 0; i < t; i++) {
        int n = Integer.parseInt(br.readLine());
        System.out.println(dp.get(n).size());
      }

    } catch (IOException e) {}

  }
}
