using System;
using System.IO;
using System.Text;
using System.Collections.Generic;
using System.Linq;

namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Stack<int> stack = new Stack<int>();
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < n; i++)
            {
                StringReader reader = new StringReader(Console.ReadLine());
                string[] s = reader.ReadLine().Split();
                if (s.Length > 1)
                    stack.Push(int.Parse(s[1]));
                else
                {
                    int length = stack.Count();
                    switch(s[0])
                    {
                        case "pop":
                            if (length > 0)
                            {
                                builder.Append(stack.Peek() + "\n");
                                stack.Pop();
                            }
                            else
                                builder.Append("-1\n");
                            break;

                        case "size":
                            builder.Append(length + "\n");
                            break;

                        case "empty":
                            int result = (length > 0) ? 0 : 1;
                            builder.Append(result + "\n");
                            break;

                        case "top":
                            if (length > 0)
                                builder.Append(stack.Peek() + "\n");
                            else
                                builder.Append("-1\n");
                            break;
                    }
                }
            }
            Console.WriteLine(builder);
        }
    }
}