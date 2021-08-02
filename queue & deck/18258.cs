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
            StringBuilder builder = new StringBuilder();
            Queue<int> queue = new Queue<int>();
            int back_queue = -1;
            for (int i = 0; i < n; i++)

            {
                StringReader reader = new StringReader(Console.ReadLine());
                string command = reader.ReadLine();

                if (command.Length > 5)
                {
                    string[] push = command.Split();
                    back_queue = int.Parse(push[1]);
                    queue.Enqueue(back_queue);
                }
                else
                {
                    int count = queue.Count();
                    switch (command)
                    {
                        case "pop":
                            if (count != 0)
                                builder.Append(queue.Dequeue().ToString() + "\n");
                            else
                                builder.Append("-1\n");
                            break;

                        case "size":
                            builder.Append(count.ToString() + "\n");
                            break;

                        case "empty":
                            builder.Append((count != 0) ? "0\n" : "1\n");
                            break;

                        case "front":
                            if (count != 0)
                                builder.Append(queue.Peek().ToString() + "\n");
                            else
                                builder.Append("-1\n");
                            break;

                        case "back":
                            if(count != 0)
                                builder.Append(back_queue.ToString() + "\n");
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