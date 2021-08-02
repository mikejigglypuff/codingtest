using System;
using System.IO;
using System.Collections.Generic;

namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Stack<int> stack = new Stack<int>();
            for(int i = 0; i < n; i++)
            {
                StringReader reader = new StringReader(Console.ReadLine());
                int num = int.Parse(reader.ReadLine());
                if (num == 0)
                    stack.Pop();
                else
                    stack.Push(num);
            }

            int result = 0;
            foreach (int i in stack)
                result += i;
            Console.WriteLine(result);
        }
    }
}