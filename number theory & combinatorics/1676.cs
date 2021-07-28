using System;

namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int result = 0;
            for(int i = 1; i < n + 1; i++)
            {
                if (i % 5 == 0)
                {
                    if (i % 25 == 0)
                    {
                        if (i % 125 == 0)
                            result += 3;
                        else
                            result += 2;
                    }
                    else
                        result += 1;
                }    
            }
            Console.WriteLine(result);
        }
    }
}