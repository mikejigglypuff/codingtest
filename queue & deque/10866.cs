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
            StringBuilder builder = new StringBuilder();
            int n = int.Parse(Console.ReadLine());
            LinkedList<int> linkedlist = new LinkedList<int>();

            for(int i = 0; i < n; i++)
            {
                StringReader reader = new StringReader(Console.ReadLine());
                string[] s = reader.ReadLine().Split();

                if(s.Length > 1)
                {
                    if (s[0] == "push_back")
                        linkedlist.AddFirst(int.Parse(s[1]));
                    else
                        linkedlist.AddLast(int.Parse(s[1]));
                }
                else
                {
                    int count = linkedlist.Count();
                    switch(s[0])
                    {
                        case "pop_front":
                            if (count == 0)
                                builder.Append("-1\n");
                            else
                            {
                                builder.Append(linkedlist.Last.Value.ToString() + "\n");
                                linkedlist.RemoveLast();
                            }
                            break;

                        case "pop_back":
                            if (count == 0)
                                builder.Append("-1\n");
                            else
                            {
                                builder.Append(linkedlist.First.Value.ToString() + "\n");
                                linkedlist.RemoveFirst();
                            }
                            break;

                        case "size":
                            builder.Append(count.ToString() + "\n");
                            break;

                        case "empty":
                            string empty = (count != 0) ? "0" : "1";
                            builder.Append(empty + "\n");
                            break;

                        case "front":
                            if (count == 0)
                                builder.Append("-1\n");
                            else
                                builder.Append(linkedlist.Last.Value.ToString() + "\n");
                            break;

                        case "back":
                            if (count == 0)
                                builder.Append("-1\n");
                            else
                                builder.Append(linkedlist.First.Value.ToString() + "\n");
                            break;
                    }
                }
            }

            Console.WriteLine(builder);
        }
    }
}