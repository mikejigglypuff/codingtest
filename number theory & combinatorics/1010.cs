using System;
using System.Collections.Generic;

namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            int t = int.Parse(Console.ReadLine());
            for (int i = 0; i < t; i++)
            {
                string nm = Console.ReadLine();
                string[] nandk = nm.Split(" ");
                int n = int.Parse(nandk[0]), m = int.Parse(nandk[1]);

                long[][] dynamic = new long[m][];
                dynamic[0] = new long[1];
                dynamic[0][0] = 1;
                for(int j = 1; j < m; j++)
                {
                    dynamic[j] = new long[j + 1];
                    dynamic[j][0] = j + 1;
                    for (int k = 1; k < j; k++)
                        dynamic[j][k] = dynamic[j - 1][k - 1] + dynamic[j - 1][k];
                    dynamic[j][j] = 1;
                }
                Console.WriteLine(dynamic[m - 1][n - 1]);
            }
        }
    }
}