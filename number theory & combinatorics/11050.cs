using System;
using System.Collections.Generic;

namespace baekjoonC____
{
    class Program
    {
        static int bi_coefficient(int n, int k)
        {
            int nfac = 1, kfac = 1, minusfac = 1;
            for(int i = n; i > 1; i--)
            {
                nfac *= i;
                if (i <= k)
                    kfac *= i;
                if (i <= n - k)
                    minusfac *= i;
            }
            return nfac / (kfac * minusfac);
        }
        static void Main(string[] args)
        {
            string nk = Console.ReadLine();
            string[] nandk = nk.Split(" ");
            int n = int.Parse(nandk[0]), k = int.Parse(nandk[1]);
            Console.WriteLine(bi_coefficient(n, k));
        }
    }
}