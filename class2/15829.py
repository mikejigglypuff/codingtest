r = 31
M = 1234567891

def hashing(s):
    result, count = 0, 0
    for i in s:
        num = ord(i) - 96
        result += num * (r ** count % M) % M
        result %= M
        count += 1
    
    return result

n = int(input())
s = input()
print(hashing(s))