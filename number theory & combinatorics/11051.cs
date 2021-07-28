using System;
using System.Collections.Generic;

namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            string nk = Console.ReadLine();
            string[] nandk = nk.Split(" ");
            int n = int.Parse(nandk[0]), k = int.Parse(nandk[1]);

            int[][] dynamic = new int[n][];
            dynamic[0] = new int[2] {1, 1};

            for(int i = 2; i <= n; i++)
            {
                dynamic[i - 1] = new int[i + 1];
                dynamic[i - 1][0] = 1;
                for(int j = 1; j < i; j++)
                    dynamic[i - 1][j] = (dynamic[i - 2][j - 1] + dynamic[i - 2][j]) % 10007;
                dynamic[i - 1][i] = 1;
            }
            Console.WriteLine(dynamic[n - 1][k]);
        }
    }
}