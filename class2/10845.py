class Queue:
    def __init__(self):
        self.array = []
        self.len = 0
    
    def push(self, n):
        self.array.append(n)
        self.len += 1
    
    def pop(self):
        if(self.len > 0):
            self.len -= 1
            result = self.array.pop(0)
            print(result)
        else:
            print("-1")

    def size(self):
        print(self.len)

    def empty(self):
        result = 1 if not self.len else 0
        print(result)

    def front(self):
        if(self.len > 0):
            print(self.array[0])
        else:
            print("-1")

    def back(self):
        if(self.len > 0):
            print(self.array[self.len - 1])
        else:
            print("-1")

    def input(self, str):
        if(str[:4] == "push"):
            spli = str.split(" ")
            self.push(spli[1])
        elif(str == "pop"):
            self.pop()
        elif(str == "size"):
            self.size()
        elif(str == "empty"):
            self.empty()
        elif(str == "front"):
            self.front()
        elif(str == "back"):
            self.back()
        

import sys

queue = Queue()
n = int(input())
for i in range(n):
    s = sys.stdin.readline().rstrip()
    queue.input(s)
