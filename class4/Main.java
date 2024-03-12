package class4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int maxLies = 0;
    static int m, n;
    static boolean[] visited, knowList;
    static boolean[][] partyList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer nm = new StringTokenizer(br.readLine());
        n = Integer.parseInt(nm.nextToken());
        m = Integer.parseInt(nm.nextToken());
        visited = new boolean[m];
        knowList = new boolean[n + 1];
        partyList = new boolean[m][n + 1];

        StringTokenizer knows = new StringTokenizer(br.readLine());
        int knum = Integer.parseInt(knows.nextToken());
        for(int i = knum; i > 0; i--) {
            knowList[Integer.parseInt(knows.nextToken())] = true;
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer parties = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(parties.nextToken());
            while (parties.hasMoreTokens()) {
                partyList[i][Integer.parseInt(parties.nextToken())] = true;
            }
        }

        for(int i = 0; i < m; i++) {
            if(!visited[i]) Search(i);
        }

        for(boolean b : visited) {
            if(!b) ++maxLies;
        }

        System.out.println(maxLies);
    }

    public static void Search(int index) {
        boolean lies = true;
        List<Integer> knows = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            if(partyList[index][i]) {
                knows.add(i);
                if(knowList[i]) lies = false;
            }

        }

        if(!lies) {
            visited[index] = true;
            for(int num : knows) {
                knowList[num] = true;

                for(int i = 0; i < m; i++) {
                    if(partyList[i][num] && !visited[i]) Search(i);
                }
            }
        }
    }
}