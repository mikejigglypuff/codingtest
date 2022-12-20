import java.util.*;

public class b10816 {

	public static List<Integer> Merge_Sort(int n, List<Integer> ncard) {
		if(n <= 1) { return ncard; }

		int x = n / 2, y = ncard.size() - x;

		List<Integer> div1 = Merge_Sort(x, ncard.subList(0, x));
		List<Integer> div2 = Merge_Sort(y, ncard.subList(x, ncard.size()));

		return Merge(div1, div2, x, y);

	}

	public static List<Integer> Merge(List<Integer> div1, List<Integer> div2,
																				 int len1, int len2) {
		int i = 0, j = 0, d1 = 0, d2 = 0;
		List<Integer> result = new ArrayList<Integer>();

		while (i < len1 && j < len2) {
			d1 = div1.get(i);
		  d2 = div2.get(j);
			if(d1 <= d2){
				result.add(d1);
				i++;
			}
      else {
				result.add(d2);
				j++;
			}
		}

		while(i < len1) {
			result.add(div1.get(i));
			i++;
		}
		while(j < len2) {
			result.add(div2.get(j));
			j++;
		}

		return result;
	}

	public static HashMap<Integer, Integer> makehash(int n, List<Integer> ncard) {
		HashMap<Integer, Integer> hash = new HashMap<>();
		int prev = ncard.get(0);
		hash.put(prev, 1);

		int i, x;
		for(i = 1; i < n; i++) {
			if(ncard.get(i) == prev) {
				x = hash.get(prev) + 1;
			}
			else {
				prev = ncard.get(i);
				x = 1;
			}
			hash.put(prev, x);
		}


		return hash;
	}

	public static void main(String[] Args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> ncard = new ArrayList<Integer>();
		List<Integer> nums = new ArrayList<Integer>();

		int n = Integer.parseInt(sc.nextLine());
		StringTokenizer stn = new StringTokenizer(sc.nextLine());
		while(stn.hasMoreElements()) {
			ncard.add(Integer.parseInt(stn.nextToken()));
		}

		int m = Integer.parseInt(sc.nextLine());
		StringTokenizer stm = new StringTokenizer(sc.nextLine());
		while(stm.hasMoreElements()) {
			nums.add(Integer.parseInt(stm.nextToken()));
		}

		ncard = Merge_Sort(n, ncard);
		HashMap<Integer, Integer> nhash = makehash(n, ncard);

		int i, x;
		for(i = 0; i < m; i++) {
			try {
				x = nhash.get(nums.get(i));
				nums.set(i, x);
			} catch (Exception e) {
				nums.set(i, 0);
			}
		}

		String str = "";
		for(int j = 0; j < nums.size() - 1; j++) {
			str += nums.get(j).toString() + " ";
		}
		str += nums.get(nums.size() - 1).toString();
		System.out.println(str);
	}
}
