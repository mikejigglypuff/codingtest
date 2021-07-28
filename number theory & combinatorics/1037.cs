using System;

namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            int x = int.Parse(Console.ReadLine());

            string s = Console.ReadLine();
            string[] ss = s.Split(" ");

            int[] num = new int[x];

            for(int i = 0; i < x; i++)
                num[i] = int.Parse(ss[i]);

            int min = num[0], max = num[0];
            foreach(int i in num)
            {
                if (i > max)
                    max = i;
                else if (i < min)
                    min = i;
            }
            Console.WriteLine(min * max);
        }
    }
}