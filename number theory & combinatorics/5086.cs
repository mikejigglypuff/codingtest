using System;

namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            while(true)
            {
                string s = Console.ReadLine();
                string[] ss = s.Split(" ");
                int a = int.Parse(ss[0]);
                int b = int.Parse(ss[1]);
                if (a == 0 && b == 0)
                    break;
                if (a % b == 0)
                    Console.WriteLine("multiple");
                else if(b % a == 0)
                    Console.WriteLine("factor");
                else
                    Console.WriteLine("neither");
            }
        }
    }
}