using System;

namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            int x = int.Parse(Console.ReadLine());

            for (int i = 0; i < x; i++)
            {
                string s = Console.ReadLine();
                string[] ss = s.Split(" ");

                int a = int.Parse(ss[0]), b = int.Parse(ss[1]);
                int c = (a < b) ? a : b, d = (a < b) ? b % c : a % c;
                while(d != 0)
                {
                    int e = c;
                    c = d;
                    d = e % c;
                }
                Console.WriteLine(a * b / c);
            }
        }
    }
}