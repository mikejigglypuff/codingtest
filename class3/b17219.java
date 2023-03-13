package class3;

import java.io.*;
import java.util.*;

public class b17219 {

  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try{
      String[] input = br.readLine().split(" ");
      int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
      HashMap<String, String> site_pass = new HashMap<>();

      while (n-- > 0) {
        input = br.readLine().split(" ");
        site_pass.put(input[0], input[1]);
      }

      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      while (m-- > 0) {
        bw.write(site_pass.get(br.readLine()) + "\n");
      }

      bw.flush();

    } catch (IOException e) {}
  }
}
