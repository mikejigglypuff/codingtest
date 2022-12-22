import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class b10816 {

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

	public static HashMap<Integer, Integer> makehash(int n, int[] ncard) {
		HashMap<Integer, Integer> hash = new HashMap<>();
		int prev = ncard[0];
		hash.put(prev, 1);

		int i, x;
		for(i = 1; i < n; i++) {
			if(ncard[i] == prev) {
				x = hash.get(prev) + 1;
			}
			else {
				prev = ncard[i];
				x = 1;
			}
			hash.put(prev, x);
		}


		return hash;
	}

	public static void main(String[] Args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));



		try {
			int n = Integer.parseInt(bf.readLine());
			int[] ncard = new int[n];
			String[] card_nums = bf.readLine().split(" ");

			int i;
			for (i = 0; i < n; i++) {
				ncard[i] = Integer.parseInt(card_nums[i]);
			}

			int m = Integer.parseInt(bf.readLine());
			int[] nums = new int[m];
			String[] target_nums = bf.readLine().split(" ");

			for (i = 0; i < m; i++) {
				nums[i] = Integer.parseInt(target_nums[i]);
			}

			ncard = Merge_Sort(n, ncard);
			HashMap<Integer, Integer> nhash = makehash(n, ncard);

			int x;
			for (i = 0; i < m; i++) {
				try {
					x = nhash.get(nums[i]);
					nums[i] = x;
				} catch (Exception e) {
					nums[i] = 0;
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < m; j++) {
				sb.append(nums[j] + " ");
			}
			System.out.println(sb);
		} catch (IOException e) {
			
		}
	}
}
