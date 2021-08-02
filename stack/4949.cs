using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;

namespace baekjoonC____
{
    class Program
    {
        static void Main(string[] args)
        {
            StringBuilder builder = new StringBuilder();
            string s = Console.ReadLine();
            while(s != ".")
            {
                Stack<char> brace = new Stack<char>();
                bool fail = false;
                for(int i = 0; i < s.Length; i++)
                {
                    if (fail)
                        break;
                    switch(s[i])
                    {
                        case '(':
                        case '[':
                            brace.Push(s[i]);
                            break;
                        case ')':
                            if (brace.Count() == 0  || brace.Peek() != '(')
                            {
                                fail = true;
                                builder.Append("no\n");
                            }
                            else
                                brace.Pop();
                            break;
                        case ']':
                            if (brace.Count() == 0 || brace.Peek() != '[')
                            {
                                fail = true;
                                builder.Append("no\n");
                            }
                            else
                                brace.Pop();
                            break;
                    }
                }
                if (!fail)
                {
                    if (brace.Count() == 0)
                        builder.Append("yes\n");
                    else
                        builder.Append("no\n");
                }
                s = Console.ReadLine();
            }
            Console.WriteLine(builder);
        }
    }
}