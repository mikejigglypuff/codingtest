package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1620 {


  public static void main(String[] Args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      String[] input = br.readLine().split(" ");
      HashMap<Integer, String> pokemons = new HashMap<Integer, String>();
      HashMap<String, Integer> reverse_poke = new HashMap<String, Integer>();
      int n = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);
      StringBuilder sb = new StringBuilder();

      int i; String pokemon;
      for(i = 0; i < n; i++) {
        pokemon = br.readLine();
        pokemons.put(i + 1, pokemon);
        reverse_poke.put(pokemon, i + 1);
      }

      String probe; int index;
      for(i = 0; i < m; i++) {
        probe = br.readLine();
        try {
          index = Integer.parseInt(probe);
          sb.append(pokemons.get(index));
        } catch(NumberFormatException e) {
          sb.append(reverse_poke.get(probe));
        } finally {
          if(i < m - 1) { sb.append("\n"); }
        }
      }

      System.out.println(sb);
    } catch (IOException e) {}

  }
}