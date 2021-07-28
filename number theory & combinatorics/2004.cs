using System;
using System.Collections.Generic;
using System.Linq;

namespace baekjoonC____
{
    class Program
    {
        static long[] num_num(long i, long n, long m, long minus)
        {
            long[] result = new long[3];
            long nnum = 0, mnum = 0, minusnum = 0;
            long max = 1;
            while (max < 2000000000)
                max *= i;
            for (long j = max; j > 1; j /= i)
            {
                if (n < j)
                    continue;
                nnum += n / j;
                if (m >= j)
                    mnum += m / j;
                if (minus >= j)
                    minusnum += minus / j;
            }
            result[0] = nnum; result[1] = mnum; result[2] = minusnum;
            return result;
        }
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            long n = long.Parse(s[0]), m = long.Parse(s[1]);
            long minus = n - m;

            long[] f = num_num(5, n, m, minus);
            long[] t = num_num(2, n, m, minus);
            Console.WriteLine(Math.Min(f[0] - (f[1] + f[2]), t[0] - (t[1] + t[2])));
        }
    }
}